class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int slen = arr1.length;
        int tlen = arr2.length;
         dp = new int[slen][tlen];
         for(int i = 0; i <  dp.length ; i++){
            Arrays.fill(dp[i] , -1);
         }
    
    return helper(arr1 , arr2 , slen , tlen , 0 , 0);
        
    }
    public int helper(char[] s , char[] t , int slen , int tlen , int sindex , int tindex){
        if(tindex == tlen) return 1;
        if(sindex >= slen) return 0;

        if(dp[sindex][tindex] != -1) return dp[sindex][tindex];
        int pick = 0;
        int skip = 0;
        if(s[sindex] == t[tindex]){
            pick = helper(s , t , slen , tlen , sindex+1 , tindex+1);
        }
               skip = helper(s , t , slen , tlen , sindex+1 , tindex);

        return   dp[sindex][tindex] = pick + skip;

    }
}