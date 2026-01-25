class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() +1];
     helper(0 , s , wordDict ,dp);

    return dp[0];
    }

    public boolean helper(int index , String s , List<String> list , Boolean[] dp){
        if(index >= s.length()){
               return true;
        }

        if(dp[index] != null) return dp[index];

        for(int i = index+1  ; i <= s.length() ; i++){
            String temp = s.substring(index , i);
            System.out.println(temp);
            if(list.contains(temp) && helper( i  , s , list ,  dp )){
                return  dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}