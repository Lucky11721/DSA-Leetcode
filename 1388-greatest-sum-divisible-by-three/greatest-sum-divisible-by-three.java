class Solution {
    int[][] dp;
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][3];
        for(int i = 0  ; i < n+1 ; i++){
            Arrays.fill(dp[i] , -1);
        }
     return helper(nums , 0 , 0);   
    }

    public int helper(int[] arr , int index , int rem){
        if(index >= arr.length){
            if(rem % 3 == 0){
                if(rem == 0 ) return 0;
            }
            else{
                return -500;
            }
        }
        if(dp[index][rem] != -1) return dp[index][rem];
        int pick = arr[index] + helper(arr , index +1, (rem + arr[index]) %3);
        int skip = helper(arr , index +1 , rem);

        return dp[index][rem] = Math.max(skip , pick);
    }
}