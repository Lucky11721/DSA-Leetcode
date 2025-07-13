class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0 ; i < n +1; i++){
            Arrays.fill(dp[i] , -1);
        }
        return countWays(coins, 0, amount , dp);
    }

    public int countWays(int[] coins, int index, int amount , int[][] dp) {
        if (amount == 0) return 1;  // Found a valid combination
        if (amount < 0 || index == coins.length) return 0;  // Invalid path
        if(dp[index][amount] != -1) return dp[index][amount];
        // Option 1: Include the current coin
        int include = countWays(coins, index, amount - coins[index] , dp);

        // Option 2: Exclude the current coin and move to next
        int exclude = countWays(coins, index + 1, amount ,dp);
         dp[index][amount] = include + exclude;

        return include + exclude;
    }
}
