class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() +1];
        return helper(0 , s , wordDict ,dp);
    }

    public boolean helper(int index , String s , List<String> list , Boolean[] dp){
        if(index >= s.length()){
               return true;
        }

        if(dp[index] != null) return dp[index];

        for(int i = index+1  ; i <= s.length() ; i++){
            String temp = s.substring(index , i);
            if(list.contains(temp) && helper( i  , s , list ,  dp )){
                return  dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}