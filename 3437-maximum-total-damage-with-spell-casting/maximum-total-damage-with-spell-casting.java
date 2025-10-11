class Solution {
     HashMap<Integer , Integer> map = new HashMap<>();
     long[] dp;
    public long maximumTotalDamage(int[] power) {
        int n = power.length; 
        for(int i =  0 ; i < n ; i++ ){
            if(map.containsKey(power[i])){
                map.put(power[i] , map.get(power[i]) + 1);
            }
            else{
                map.put(power[i] ,1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ele : power){
            set.add(ele);
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for(int ele : set){
            arr[i] = ele;
            i++;
        }
        dp = new long[arr.length];
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        long ans = 0;
        for(int x = arr.length - 1; x >= 0; x-- ){
            long skip = (x + 1 < arr.length) ? dp[x + 1] : 0;
            int j = lower_bound(arr, x + 1, arr.length - 1, arr[x] + 3);
            long take = (long) arr[x] * map.get(arr[x]) + ((j < arr.length) ? dp[j] : 0);

            dp[x] = Math.max(skip, take);
            ans = Math.max(ans, dp[x]);
        }
        return ans;

    }
    

    public int lower_bound(int[] arr , int i , int j , int target){
       int ans = arr.length;
       while(i <= j){
        int mid = i + (j-i)/2;
        if(arr[mid] >= target){
            ans = mid;
            j = mid-1;
        }
        else{
            i = mid+1;
        }
       }

      return ans;
    }
}