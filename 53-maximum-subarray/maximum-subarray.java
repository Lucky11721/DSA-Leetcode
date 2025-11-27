class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxEnd = nums[0];
        int maxSum = nums[0];

        for(int i = 1 ; i < n ; i++){

            maxEnd = Math.max(maxEnd + nums[i] , nums[i] );
            maxSum = Math.max(maxEnd , maxSum);
        }

        return maxSum;
    }
}