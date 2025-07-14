class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() +1][word2.length()+1];
        for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i]  , -1);
        }
        return helper(word1, word2, word1.length(), word2.length()  , dp);
    }

    private int helper(String word1, String word2, int m, int n , int[][] dp) {
        // Base Cases
        if (m == 0) return n; // Insert all characters of word2
        if (n == 0) return m; // Delete all characters of word1
        if(dp[m][n] != -1) return dp[m][n];
        // If last characters match, move to the next pair
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return helper(word1, word2, m - 1, n - 1,  dp );
        }

        // If characters do not match, try all operations
        int insertOp = helper(word1, word2, m, n - 1 ,  dp );     // Insert
        int deleteOp = helper(word1, word2, m - 1, n,  dp );     // Delete
        int replaceOp = helper(word1, word2, m - 1, n - 1 ,  dp ); // Replace
       dp[m][n] =  1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));

        return 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }
}
