class Solution {
    int MOD  = (int)Math.pow(10 , 9) + 7;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1][k+1];
        for(int i  = 0 ; i < m ; i++){
            for(int j = 0 ;j < n ; j++){
                for(int x= 0 ; x < k+1 ; x++){
                    dp[i][j][x]  = -1;
                }
            }
        }
        return helper(grid , k , 0 , 0 , grid[0][0] % k  , m , n) % MOD;

    }
    public int helper(int[][] grid , int k , int row , int col, int sum , int m , int n){
      if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1){
            if(sum % k == 0){
               return 1;
            }
            else{
                return 0;
            }

        }
        if(dp[row][col][sum] != -1) return dp[row][col][sum];
         int down = 0;
         if(row +1 < m){
            down = helper(grid , k , row+1 , col , (sum + grid[row+1][col]) % k  , m , n );
         }
         int right = 0;
         if(col +1< n){
            right = helper(grid , k , row , col +1  , (sum + grid[row][col+1]) % k  , m , n );
         }
         return dp[row][col][sum] = (down + right) % MOD;
    }
}