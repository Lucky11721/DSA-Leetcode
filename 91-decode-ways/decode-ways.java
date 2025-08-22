class Solution {
    public int numDecodings(String s) {
     
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length+1];
        Arrays.fill(dp , -1);
        return helper(ch , 0 , dp);
    }
    public int helper(char[] arr , int i , int[] dp){
        if(i == arr.length) return 1;

        if(arr[i] == '0') return 0;
       if(dp[i] != -1) return dp[i];

        int take1char = helper(arr , i+1 ,dp);
        int take2char = 0;

        if(i+1 < arr.length){
            if(arr[i] == '1' && arr[i+1] <= '9' || arr[i] == '2' && arr[i+1] <= '6'){
                take2char += helper(arr , i+2 ,dp);
            }
        }
        dp[i] = take1char + take2char;
        return dp[i];
    }
}