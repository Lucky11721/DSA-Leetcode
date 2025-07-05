class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        
        // Traverse the array twice (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            
            // Maintain a decreasing stack
            while (!st.isEmpty() && nums[st.peek()] <= curr) {
                st.pop();
            }

            if (i < n) { // Only fill answers in the first pass
                if (!st.isEmpty()) {
                    ans[i] = nums[st.peek()];
                }
            }
            st.push(i % n);
        }
        
        return ans;
    }
}
