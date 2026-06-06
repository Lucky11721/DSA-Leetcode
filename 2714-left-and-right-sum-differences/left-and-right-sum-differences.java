class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length;

        int[] ans = new int[n];

        for(int i = 0 ;  i< n ; i++){
            int j = i -1;
            int k = i+1;
            int leftSum = 0;
            int rightSum = 0;

            while(j >= 0){
                leftSum += nums[j];
                j--;
            }
            while(k < n){
                rightSum += nums[k];
                k++;
            }

            ans[i] = Math.abs(leftSum - rightSum);

        }


        return ans;
    }
}