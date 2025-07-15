class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // dp[i][buy][k] → max profit on day i, with buy/sell flag and k transactions left
        Integer[][][] dp = new Integer[n][2][k + 1];
        return helper(0, 1, k, prices, dp);
    }

    public int helper(int index, int canBuy, int transactionsLeft, int[] prices, Integer[][][] dp) {
        if (index == prices.length || transactionsLeft == 0) return 0;

        if (dp[index][canBuy][transactionsLeft] != null) return dp[index][canBuy][transactionsLeft];

        int profit = 0;

        if (canBuy == 1) {
            // Option 1: Buy
            int buy = -prices[index] + helper(index + 1, 0, transactionsLeft, prices, dp);
            // Option 2: Skip
            int skip = helper(index + 1, 1, transactionsLeft, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            // Option 1: Sell
            int sell = prices[index] + helper(index + 1, 1, transactionsLeft - 1, prices, dp);
            // Option 2: Skip
            int skip = helper(index + 1, 0, transactionsLeft, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[index][canBuy][transactionsLeft] = profit;
    }
}
