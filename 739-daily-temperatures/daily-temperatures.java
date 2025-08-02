class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
          
        for(int i = 0 ; i <  n ;i++){

            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);
           
        }
        while(st.isEmpty() == false) {
            ans[st.pop()] = 0;
        }
        return ans;
    }
}