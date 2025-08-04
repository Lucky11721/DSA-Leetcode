class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int area = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int height = arr[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int curr_area = height * width;
                area = Math.max(area, curr_area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int height = arr[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            int curr_area = height * width;
            area = Math.max(area, curr_area);
        }

        return area;
    }
}
