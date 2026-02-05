class Solution {
    Boolean dp[][];
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()];
         return helper(s , 0 , 0);
    }


    public boolean helper(String s , int index , int count){
        if(count < 0) return false;

        if(index == s.length()){
            return count == 0;
        }
        if(dp[index][count] != null) return dp[index][count];

        boolean flag  = false;

        if(s.charAt(index) == '(' ){
            flag = helper(s , index +1 , count +1);
        }
        else if(s.charAt(index) == ')'){
            flag = helper(s , index+1 , count -1);
        }
        else if(s.charAt(index) == '*'){
            flag = helper(s , index +1 , count + 1 ) || helper(s , index +1 , count -1 ) ||
            helper(s , index +1 , count );
        }
        return  dp[index][count] = flag;
        
    }
}