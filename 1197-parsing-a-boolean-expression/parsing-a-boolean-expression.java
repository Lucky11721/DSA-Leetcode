class Solution {
    public boolean parseBoolExpr(String s) {
        char[] ch = s.toCharArray();

        int n = ch.length;

        Stack<Character> st = new Stack<>();
        
        for(int  i = 0 ;i < n ; i++){
            if(ch[i] == ','){
                continue;
            }
            if(ch[i] == ')'){
                ArrayList<Character> list = new ArrayList<>();
                while(st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop();
                char op = st.peek();
                st.pop();
                st.add(helper(list , op));
               
            }
            else{
                st.add(ch[i]);
            }
        }

        if(st.peek() == 't'){
            return true;
        }
        else{
            return false;
        }
    }

    public char helper( ArrayList<Character> list , char op){
        if(op == '&'){
            if(list.contains('f')){
                return 'f';
            }
            else{
                return  't';
            }
        }
        else if(op == '|'){
            if(list.contains('t')){
                return  't';
            }
            else{
                return 'f';
            }
        }
        else{
            if(list.get(0) == 't'){
                return 'f';
            }
            else{
                return 't';
            }
        }
    }
}