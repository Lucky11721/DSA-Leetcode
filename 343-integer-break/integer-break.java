class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n , dp);
    }

    public int helper(int n , int[] dp){
        if(n == 1) return 1;
       if(dp[n] != -1) return dp[n];
        int res = 0;

        for(int i = 1 ; i < n ; i++){
            int curr_ans = i * Math.max(n-i , helper(n-i ,dp));
            res = Math.max(curr_ans , res);
        }

        return dp[n] = res;
    }
}