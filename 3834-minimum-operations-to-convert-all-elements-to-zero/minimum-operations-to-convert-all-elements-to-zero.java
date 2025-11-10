class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Remove elements from stack that are greater than current
            while (!st.isEmpty() && st.peek() > arr[i]) {
                st.pop();
            }
            if(arr[i] == 0) continue;
            // If stack empty or top < current, push new value
            if (st.isEmpty() || st.peek() < arr[i]) {
                st.push(arr[i]);
                ans++;
            }
        }
        return ans;
    }
}
