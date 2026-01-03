class Solution {
    int ans = 0;
    int MOD = 1000000007;
    int[][] dp;
    public int numOfWays(int n) {
          String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    int ans = 0;
    dp = new int[n+1][13];
    for(int[] arr : dp){
        Arrays.fill(arr , -1);
    }
    for(int i = 0; i < 12 ; i++){
        ans = (ans+ ways(states,n-1 , i)) % MOD;
    }

    return ans % MOD;
    }

    public int ways(String[] states , int n , int prev ){
        if(n == 0 ) return 1;

        if(dp[n][prev] != -1) return dp[n][prev];
        String last = states[prev];

        int ans = 0;
        for(int curr = 0 ; curr < 12 ; curr++){
            if(prev == curr) continue;

            String currPattern = states[curr];
              boolean conflict = false;
            for(int i = 0 ; i < 3 ; i++){
                if(last.charAt(i) == currPattern.charAt(i)){
                    conflict = true;
                    break;
                }
            }

            if(!conflict){
                ans = (ans +  ways(states,n-1 , curr)) % MOD;
            }

        }
        return dp[n][prev] = ans;
    }
}