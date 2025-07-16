class Solution {
    public int maxProfit(int[] prices) {
        int n =  prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0 ; i < n+1 ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return helper(prices , 0  , 1 ,dp);
    }
    public int helper(int arr[] , int index , int buy , int[][] dp){

        if(index == arr.length) return 0;
      if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1){
           return  dp[index][buy] = Math.max(-arr[index] + helper(arr , index + 1 , 0 , dp) , 
           0 + helper(arr , index+1 , 1 , dp));
        }
        else{
            return  dp[index][buy] =  Math.max(arr[index] + helper(arr , index +1 , 1 , dp) ,
            0 + helper(arr , index +1 , 0 , dp));
        }
    }
}