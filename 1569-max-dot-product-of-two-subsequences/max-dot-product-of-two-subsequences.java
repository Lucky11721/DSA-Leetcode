class Solution {

    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m][n];

       for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          dp[i][j] = Integer.MIN_VALUE;
        }
       }
        return helper(nums1 , nums2 , 0 , 0);
    }
      public int helper(int[] arr1 , int[] arr2 , int i , int j){
       
        if(i >= arr1.length || j >= arr2.length){
          
            return Integer.MIN_VALUE/2;
        }
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int val = arr1[i]*arr2[j];
        int take = (arr1[i] * arr2[j]) + helper(arr1 , arr2 , i+1 , j+1);

        int skip1 = helper(arr1 , arr2 , i+1 , j);
        int skip2 = helper(arr1 , arr2 , i , j+1);

        return dp[i][j] = Math.max(val,Math.max(take ,  Math.max(skip1,skip2)));
    }
}