class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums , 0 , 0 , target);
    }

    public int helper(int[] arr , int index , int sum , int target){
        if(index == arr.length){
            if(sum == target) return 1;
            return 0;
        }

        int add = helper(arr , index +1 , sum + arr[index] , target);
         int sub = helper(arr , index +1 , sum - arr[index] , target);

         return add + sub;
    }
}