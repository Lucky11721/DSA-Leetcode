class Solution {
    public int missingNumber(int[] nums) {
        

        Arrays.sort(nums);

        int ans = -1;
        for(int i = 1 ; i < nums.length; i++ ){
            if(nums[i] - nums[i-1] > 1){
                ans = nums[i] -1;
                break;
            }
        }

       if(ans == -1){
        if(nums[0] > 0) return 0;
        else return nums[nums.length-1]+1;
       }

       return ans;
    }
}