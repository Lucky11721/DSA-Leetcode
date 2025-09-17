class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.equals("") && s2.equals(s3)) return true;
         if(s2.equals("")&& s1.equals(s3)) return true;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        dp = new Boolean[arr1.length +1 ][arr2.length + 1][arr3.length + 1];
        int  i =0 ;
        int j = 0 ;
         int k  =0;

         return helper(arr1 , arr2 , arr3 , i , j , k);
        
    }

    public boolean helper(char[] arr1 , char[] arr2 , char[] arr3 , int i , int j , int k  ){
        if(  k == arr3.length){
            return i==arr1.length && j == arr2.length;
        }

        if(dp[i][j][k] != null)  return dp[i][j][k];
        boolean iflag = false;
        boolean jflag = false;
        if(i < arr1.length ){
            if(arr1[i] == arr3[k]){
            iflag = helper(arr1 , arr2 , arr3 , i+1 , j , k+1 );
        }
        }
          if(j < arr2.length){
             if(arr2[j] == arr3[k]){
             jflag = helper(arr1 , arr2 , arr3 , i , j+1 , k+1 );
        }
        }

        return dp[i][j][k] =  iflag || jflag;
    }
}