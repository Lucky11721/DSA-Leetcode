class Solution {
    public boolean checkString(String s) {
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ;  i< n ; i++){
            if(!st.isEmpty() &&i > st.peek() && s.charAt(i) == 'a'){
                return false;
            }

            if(s.charAt(i) == 'b') st.push(i);
        }

        return true;
    }
}