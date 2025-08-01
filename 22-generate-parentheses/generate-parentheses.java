class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        helper("", 2 * n);

        return ans;
    }

    public void helper(String str, int len) {
        if (str.length() == len) {

            if (isValid(str) == true) {
                ans.add(str);
            }
            return;
        }

        helper(str + "(", len);
        helper(str + ")" , len);
    }

    public boolean isValid(String str) {
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(')
                count++;
            else
                count--;
        
        if(count < 0) return false;
        }
        if (count == 0)
            return true;

        return false;
    }
}