class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n =nums.length;
        int sum = 0;
        for(int ele : nums){
            sum += ele;
        }
 dp = new Boolean[n+1][sum/2 + 1];
        if(sum % 2 != 0) return false;
        else return helper(nums ,sum /2 , 0);
    }
    public boolean helper(int[] arr , int target , int index){
        if(target < 0) return false;
        if(index == arr.length){
            if(target == 0) return true;
            else return false;
        }
        if(dp[index][target] != null) return dp[index][target];

        boolean pick = helper(arr , target - arr[index] , index +1);

        boolean skip = helper(arr , target , index+1);

        return dp[index][target] = pick || skip;
    }
}