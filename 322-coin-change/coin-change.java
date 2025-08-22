import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2); // mark uncomputed
        int ans = helper(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -2) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        dp[amount] = min;
        return dp[amount];
    }
}
