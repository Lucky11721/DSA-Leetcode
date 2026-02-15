class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int x : nums){
            totalSum += x;
        }

        int maxSum = maxSum(nums);

        int minSum = minSum(nums);

      if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);

        
    }

    public int minSum(int[] nums){
         int n = nums.length;

        int currMin = nums[0];
        int minSum = nums[0];

        for(int i = 1 ; i < n ; i++ ){
            currMin = Math.min(currMin + nums[i] , nums[i]);
            minSum = Math.min(currMin , minSum);
        }

        return minSum;
    }

    public int maxSum(int[] nums){
        int n = nums.length;

        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1 ; i < n ; i++ ){
            currSum = Math.max(currSum + nums[i] , nums[i]);
            maxSum = Math.max(currSum , maxSum);
        }

        return maxSum;
    }
}