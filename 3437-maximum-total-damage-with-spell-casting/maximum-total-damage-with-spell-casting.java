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
        Arrays.fill(dp , -1);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        return helper(arr , 0);

    }
    public long helper(int[] arr , int index){
        if(index >= arr.length) return 0;

        if(dp[index] != -1) return dp[index];

        long  take = (long)arr[index] * map.get(arr[index]) + helper(arr , lower_bound(arr , index+1 , arr.length-1 , arr[index] +3));
          long skip = helper(arr , index+1);

        return dp[index] = Math.max(take , skip);

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