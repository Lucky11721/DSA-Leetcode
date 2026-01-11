class Solution {
    int ans = 0;
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
       
         int m = matrix.length;
         int n = matrix[0].length;
         dp = new int[m+1][n+1];
         for(int[] arr : dp){
            Arrays.fill(arr ,-1);
         }
           helper(matrix , 0 , 0);
         return ans * ans;
    }

    public int helper(char[][] mat , int i , int j){
        if(i >= mat.length || j >= mat[0].length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right = helper(mat , i , j+1);
        int diag = helper(mat , i+1 , j+1);
        int down = helper(mat , i+1 , j);

        if(mat[i][j] == '1'){
            ans = Math.max(ans ,dp[i][j] = 1+ Math.min(right , Math.min(diag , down)));

            return  1+ Math.min(right , Math.min(diag , down));
        }
        else{
            dp[i][j] = 0;
        }

        return dp[i][j];
    }

}