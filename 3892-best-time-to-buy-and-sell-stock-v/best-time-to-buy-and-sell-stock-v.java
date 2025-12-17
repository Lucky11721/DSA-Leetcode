class Solution {
    long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][n/2+1][3];
        return helper(prices , 0 , k , 0);

    }

    public long helper(int[] prices , int index , int k , int choice){
        if(index == prices.length){
            if(choice == 0) return 0;

            return Long.MIN_VALUE/2;
        }
        if(dp[index][k][choice] != 0) return dp[index][k][choice];
        long skip = helper(prices , index +1 , k , choice);
        
        long take = Long.MIN_VALUE;
        if(k > 0){

            if(choice == 1){
                take  = prices[index] + helper(prices , index+1 , k -1 , 0);
            }
            else if(choice == 2){
                take = -prices[index] +helper(prices , index +1 , k-1 , 0);
            }
            else{
                take = Math.max(-prices[index] + helper(prices , index +1 , k , 1) , 
                prices[index] + helper(prices , index +1 , k , 2) );
            }
        }
        

        return dp[index][k][choice] = Math.max(take , skip);
            }
}