class Solution {

    static final int MOD = 1000000007;
    int[][][] dp;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {

        this.limit = limit;

        dp = new int[zero + 1][one + 1][3];

        for(int i = 0; i <= zero; i++){
            for(int j = 0; j <= one; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return dfs(zero, one, 2);
    }

    int dfs(int zero, int one, int last){

        if(zero == 0 && one == 0) return 1;

        if(dp[zero][one][last] != -1)
            return dp[zero][one][last];

        long ans = 0;

        // place zeros
        if(last != 0){
            for(int k = 1; k <= limit && k <= zero; k++){
                ans += dfs(zero - k, one, 0);
                ans %= MOD;
            }
        }

        // place ones
        if(last != 1){
            for(int k = 1; k <= limit && k <= one; k++){
                ans += dfs(zero, one - k, 1);
                ans %= MOD;
            }
        }

        return dp[zero][one][last] = (int) ans;
    }
}