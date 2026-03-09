class Solution {

    static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[zero + 1][one + 1][2];

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {

                // ending with 0
                for (int k = 1; k <= limit && k <= z; k++) {
                    dp[z][o][0] = (dp[z][o][0] + dp[z - k][o][1]) % MOD;
                }

                // ending with 1
                for (int k = 1; k <= limit && k <= o; k++) {
                    dp[z][o][1] = (dp[z][o][1] + dp[z][o - k][0]) % MOD;
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}