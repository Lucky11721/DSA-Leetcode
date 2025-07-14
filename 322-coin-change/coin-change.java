import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int finalAns = helper(coins, 0, amount, dp);
        return finalAns == Integer.MAX_VALUE ? -1 : finalAns;
    }

    public int helper(int[] arr, int index, int amount, int[][] dp) {
        if (amount == 0) return 0; // No more coins needed
        if (amount < 0 || index == arr.length) return Integer.MAX_VALUE;

        if (dp[index][amount] != -1) return dp[index][amount];

        // Include current coin
        int include = helper(arr, index, amount - arr[index], dp);
        if (include != Integer.MAX_VALUE) include += 1; // count this coin only if valid path

        // Exclude current coin
        int exclude = helper(arr, index + 1, amount, dp);

        dp[index][amount] = Math.min(include, exclude);
        return dp[index][amount];
    }
}
