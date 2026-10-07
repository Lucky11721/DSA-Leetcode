class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.add(ch);
            }
            else{
                if(st.isEmpty() ==false && st.peek() == '(' &&  ch == ')') st.pop();
                else{
                    st.add(ch);
                }
            }
            if(!st.isEmpty())System.out.println(st.peek());
            
        }

        return st.size();
    }
}