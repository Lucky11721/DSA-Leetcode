class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n+1][m+1];

        for(int i = 0 ; i < n +1; i++){
            Arrays.fill(dp[i],-1);
        }
        int maxPath = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, helper(matrix, i, n, j, m, Integer.MIN_VALUE));
            }
        }

        return maxPath;
    }

    public int helper(int[][] arr, int row, int n, int col, int m, int prev) {
        if (row < 0 || col < 0 || row >= n || col >= m) return 0;

        if (arr[row][col] <= prev) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int right = 1 + helper(arr, row, n, col + 1, m, arr[row][col]);
        int left  = 1 + helper(arr, row, n, col - 1, m, arr[row][col]);
        int up    = 1 + helper(arr, row - 1, n, col, m, arr[row][col]);
        int down  = 1 + helper(arr, row + 1, n, col, m, arr[row][col]);

        return dp[row][col] =  Math.max(right, Math.max(left, Math.max(up, down)));
    }
}
