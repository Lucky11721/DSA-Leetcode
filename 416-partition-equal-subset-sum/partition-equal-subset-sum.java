class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums){
            sum += ele;
        }
        if(sum % 2 != 0) return false;
        dp = new Boolean[nums.length +1 ][sum/2 +1];

        return helper(nums , 0 , sum /2);
    }

    public boolean helper(int[] arr , int index , int target){
        if(target < 0) return false;
        if(index == arr.length ){
            if(target == 0) return true;
            else return false;
        }
        if(dp[index][target] != null) return dp[index][target];
        boolean pick = helper(arr , index+1 , target - arr[index]);
        boolean skip = helper(arr , index +1 , target);

        return dp[index][target] = pick || skip;
    }
}