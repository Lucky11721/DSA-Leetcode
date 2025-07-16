class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(prices, 0, 1, k , dp);
    }

    public int helper(int[] arr, int index, int buy, int cap ,  int[][][] dp) {

        if (index == arr.length || cap == 0)
            return 0;

        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        if (buy == 1) {

            return dp[index][buy][cap] =  Math.max(-arr[index] + helper(arr, index + 1, 0, cap , dp), 0 +
                    helper(arr, index + 1, 1, cap , dp));
        } else {
            return dp[index][buy][cap] =  Math.max(arr[index] + helper(arr, index + 1, 1, cap - 1 , dp), 0 +
                    helper(arr, index + 1, 0, cap , dp));
        }
    }
}