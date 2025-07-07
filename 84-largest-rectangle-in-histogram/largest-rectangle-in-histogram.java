class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        Stack<Integer> left_stack = new Stack<>();

        int[] left = new int[n];

        for (int i = 0; i < n; i++) {

            while (left_stack.isEmpty() == false && heights[left_stack.peek()] >= heights[i]) {
                left_stack.pop();
            }

            if (left_stack.isEmpty())
                left[i] = -1;
            else
                left[i] = left_stack.peek();

            left_stack.push(i);
        }

        int[] right = new int[n];
        Stack<Integer> right_stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (right_stack.isEmpty() == false && heights[right_stack.peek()] >= heights[i]) {
                right_stack.pop();
            }

            if (right_stack.isEmpty())
                right[i] = n;
            else
                right[i] = right_stack.peek();

            right_stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = right[i] - left[i] - 1;

            int temp_area = height * width;
            area = Math.max(area, temp_area);
        }

        return area;
    }
}