class Solution {
    int[][] dp;
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events , (a,b) -> Integer.compare(a[0],b[0]));
        dp = new int[n][3];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return helper(events , 0 , 0);
    }

    public int helper(int[][] event , int index , int count){
        if(count == 2 || index == event.length){
            return 0;
        }
        if(dp[index][count] != -1) return dp[index][count];
        int nextValidIndex = binarySearch(event , event[index][1]);
        int pick = event[index][2] + helper(event , nextValidIndex , count+1 );
        int skip = helper(event , index +1 , count);

        return dp[index][count] = Math.max(pick , skip);
    }

    public int binarySearch(int[][] event , int endTime){

        int l = 0;
        int r = event.length-1;

        int ans = event.length;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(event[mid][0] > endTime){
                r = mid-1;
                ans = mid;
            }
            else{
                l = mid+1;
            }
        }

        return ans;
    }
}