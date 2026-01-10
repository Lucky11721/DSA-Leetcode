class Solution {

    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {

        
        char[] ch1 = s1.toCharArray();

        char[] ch2 = s2.toCharArray();

        dp = new int[ch1.length][ch2.length];

        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        return helper(ch1 , ch2 , 0 , 0);
    }    

    public int helper(char[] ch1 , char[] ch2 , int i , int j){
        if(i >= ch1.length && j >= ch2.length) return 0;

        if(i == ch1.length && j < ch2.length){
            int sum =0 ;
            for(int k = j ; k < ch2.length ; k++){
                sum += (int)ch2[k];
            }
            return sum;
        }
           if(j == ch2.length && i < ch1.length){
            int sum =0 ;
            for(int k = i ; k < ch1.length ; k++){
                sum += (int)ch1[k];
            }
            return sum;
        }

        if(dp[i][j] != -1) return dp[i][j];
      
        if(ch1[i] == ch2[j]){
           return helper(ch1 , ch2 , i+1 , j +1);
        }

        int delete1 = (int)ch1[i] + helper(ch1 , ch2 , i+1 , j);

        int delete2 = (int)ch2[j] + helper(ch1 , ch2 , i , j+1);

       
        return dp[i][j] = Math.min(delete1 , delete2);
    }
}