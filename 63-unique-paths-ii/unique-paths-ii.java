class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacleGrid , 0 ,0 ,dp);
    }

    public int helper(int[][] arr , int row , int col , int[][] dp){
        if(row == arr.length || col == arr[0].length) return 0;
        if(arr[row][col] == 1) return 0;
        if(row == arr.length  -1 && col == arr[0].length -1 ){
            return 1;
        }
        if(dp[row][col] != -1) return dp[row][col];

        int right  = helper(arr , row  , col+1 ,dp);
        int down = helper(arr , row +1 , col ,dp);

        return dp[row][col] =  right + down;
    }
}