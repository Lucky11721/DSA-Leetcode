class Solution {
    public int findMiddleIndex(int[] nums) {
         int n = nums.length;

        for(int i = 0 ; i< n ; i++){
            int leftSum = 0;
            int rightSum = 0;

            for(int j = 0 ; j < i ; j++){
                leftSum = leftSum + nums[j];
            }
            for(int j = i+1 ; j < n ; j++){
                rightSum = rightSum + nums[j];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
}