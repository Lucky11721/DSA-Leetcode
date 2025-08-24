class Solution {
    int[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[nums.length+1][target+1];

        for(int i = 0 ;i   <  dp.length ; i++){
            Arrays.fill(dp[i] , -1);
        }
         return helper(nums , target , 0);
    }
    public int helper(int[]  arr , int target , int index){
        if(index >= arr.length ||  target < 0) return 0;
        if(target == 0) return 1;
     if(dp[index][target] != -1) return dp[index][target];
        int ans = 0;

        for(int i = 0; i < arr.length  ; i++){
            ans += helper(arr , target - arr[i] , i);
        }
        return dp[index][target] = ans;

        
    }
}