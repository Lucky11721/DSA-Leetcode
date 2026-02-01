class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];

        int firstMin = nums[1];
        int secondMin = nums[2];

        for(int i = 2 ; i <  nums.length ; i++){
            if(nums[i] <= firstMin){
                secondMin = firstMin;
                firstMin = nums[i]; 

            }
            else if(nums[i] > firstMin && nums[i] <= secondMin){
                secondMin = nums[i];
            }
        }

        System.out.println(ans + " " + firstMin + " " + secondMin );

        return ans + firstMin + secondMin;
    }
}