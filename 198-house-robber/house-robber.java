class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length+1];
        Arrays.fill(dp , -1);
        int start0 = helper(nums , 0 , nums.length,dp);
        int start1 = helper(nums , 1 , nums.length,dp);

        return Math.max(start0 , start1);
    }

    public int helper(int[] arr , int index , int n , int[] dp){
        if(index == n || index == n+1 || index == n+2) return 0;
        if(dp[index] != -1) return dp[index];

        dp[index] = arr[index] + Math.max( helper(arr , index+2 , n , dp) , helper(arr,index+3 , n ,dp));

        return dp[index];
    }
}