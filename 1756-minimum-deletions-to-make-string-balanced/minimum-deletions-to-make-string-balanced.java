class Solution {
    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();

        int n = arr.length;

        Stack<Character> st = new Stack<>();

        int count = 0;
       for(int i  = 0 ; i < n ; i++){

        if(st.isEmpty() == false && st.peek() == 'b' && arr[i] == 'a'){
            st.pop();
            count++;
        }
        else{
            st.add(arr[i]);
        }
       }
       return count;
    }
}