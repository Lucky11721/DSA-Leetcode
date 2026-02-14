class Solution {

    double dp[][];
    public double champagneTower(int poured, int query_row, int query_glass) {

        dp = new double[101][101];
        for(double[] arr : dp){
            Arrays.fill(arr , -1.0);
        }
        return Math.min(1 , helper(poured , query_row , query_glass));
    }
    public double helper(int poured , int row , int col){
        if(row < 0 || col < 0 || row < col) return 0.0;

        if(row == 0 && col == 0) return poured;
        if(dp[row][col] != -1.0) return dp[row][col];

        double upLeft = (helper(poured , row-1 , col-1) - 1 )/2.0;
        double upRight = (helper(poured , row-1 , col) - 1 )/2.0;
        if(upLeft < 0) upLeft = 0;
        if(upRight < 0) upRight = 0;


        return dp[row][col] = upLeft + upRight;
    }
}