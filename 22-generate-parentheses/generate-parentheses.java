class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(0 , 0, n , "");
        return ans;
    }

    public void helper(int open , int close , int n , String str){
        if(str.length() == 2* n){
            ans.add(str);
            return;
        }

        if(open < n) helper(open+1 , close , n , str + "(");
        if(close <  open) helper(open , close+1 , n , str + ")");
    }
}