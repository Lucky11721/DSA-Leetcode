class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st = new Stack<>();

        for(int i = 2 * n-1 ; i>= 0 ;  i--){
            int curr = nums[i%n];

            while(!st.isEmpty() && curr >= nums[st.peek()]){
                st.pop();
            }

            if(i < n){

                 if(st.isEmpty() == false){
                    ans[i%n] = nums[st.peek()];
                 }
            }




            st.push(i%n);
        }
        return ans;
    }
}