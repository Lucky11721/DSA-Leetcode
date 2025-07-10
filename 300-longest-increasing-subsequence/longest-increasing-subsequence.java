class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = 0 ; i <  n +1 ;i++){
            Arrays.fill(dp[i] , -1);
        }
        return lis(nums , -1 , 0 , dp);
    }

    public int lis(int[] arr , int preIndex , int currIndex , int[][] dp ){

        if(currIndex == arr.length){
            return 0;
        }
        if(dp[preIndex + 1][currIndex] != -1) return dp[preIndex + 1][currIndex];

        int skip = lis(arr , preIndex , currIndex + 1 , dp);

        int pick = 0;
        if(preIndex == -1 || arr[currIndex] > arr[preIndex]){
            pick = 1+  lis(arr , currIndex , currIndex + 1 ,dp);
        } 

        dp[preIndex + 1][currIndex] = Math.max(pick,skip);

        return Math.max(pick,skip);

    }
}