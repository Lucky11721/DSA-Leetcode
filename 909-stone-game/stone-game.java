class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n]; // memoization table

        int aliceScore = helper(piles, 0, n - 1, dp);

        int total = 0;
        for (int pile : piles) total += pile;

        int bobScore = total - aliceScore;

        return aliceScore > bobScore; // Alice wins if she gets more
    }

    public int helper(int[] piles, int left, int right, Integer[][] dp) {
        if (left > right) return 0;
        if (dp[left][right] != null) return dp[left][right];

        // Alice can pick either left or right pile
        int pickLeft = piles[left] + Math.min(helper(piles, left + 2, right, dp),
                                             helper(piles, left + 1, right - 1, dp));

        int pickRight = piles[right] + Math.min(helper(piles, left + 1, right - 1, dp),
                                               helper(piles, left, right - 2, dp));

        return dp[left][right] = Math.max(pickLeft, pickRight);
    }
}
