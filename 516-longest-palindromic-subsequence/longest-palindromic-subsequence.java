class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1) return 1;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0 ; i < n +1 ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return helper(ch , 0 , ch.length -1 , dp);

    }

    public int helper(char[] ch , int i , int j , int[][] dp){
      if(i >  j ) return 0;
      if(i == j) return 1;
      if(dp[i][j] != -1) return dp[i][j];
      if(ch[i] == ch[j]){
        return 2 + helper(ch , i+1 , j-1 , dp);
      }
       dp[i][j] =  Math.max(helper(ch , i+1 , j , dp) , helper(ch , i , j-1 , dp));
        return Math.max(helper(ch , i+1 , j , dp) , helper(ch , i , j-1 , dp));
      




    }
}