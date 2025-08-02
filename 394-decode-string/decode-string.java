class Solution {
    public String decodeString(String s) {

        char[] arr = s.toCharArray();

        int n = arr.length;

        Stack<Integer> int_st = new Stack<>();
        Stack<Character> char_st = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (Character.isDigit(arr[i])) {
                int num = 0;
                while (i < n && Character.isDigit(arr[i])) {
                    num = num * 10 + (arr[i] - '0');
                    i++;
                }
                int_st.push(num);
                i--;
            }
            else if(arr[i] != ']'){
                char_st.push(arr[i]);
            }
            else{
                String temp = "";
                while(char_st.isEmpty()== false && char_st.peek() != '['){
                       temp = char_st.pop() + temp;
                }
                if(char_st.isEmpty() == false && char_st.peek() == '['){
                    char_st.pop();
                }
                StringBuilder sb = new StringBuilder();
if (!int_st.isEmpty()) {
    int repeat = int_st.pop();
    for (int j = 0; j < repeat; j++) {
        sb.append(temp);
    }
}
                for(int k = 0 ; k < sb.length() ; k++){
                    char_st.push(sb.charAt(k));
                }
            }
        }
        String ans = "";
        while(char_st.isEmpty() == false){
            ans = char_st.pop() + ans;
        }
        return ans;
    }
}