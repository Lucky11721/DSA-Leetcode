class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        st.add(n-1);


        for(int i = n-2 ; i>= 0 ; i--){
            while(st.isEmpty() == false && arr[i] >= arr[st.peek()]){
                ans[i]++;
                st.pop();
            }

            if(st.isEmpty() == false && arr[i] < arr[st.peek()]){
                ans[i]++;
            }

            st.push(i);
        }

        return ans;
    }
}