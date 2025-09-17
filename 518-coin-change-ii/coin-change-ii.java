class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length +1][amount];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(coins , 0 , amount ,0);
    }

    public int helper(int[] arr , int index , int amount , int curr_amount){
        if(amount == curr_amount ) return 1;
        if(index >= arr.length || curr_amount  >  amount) return 0;
         if(dp[index][curr_amount] != -1) return dp[index][curr_amount];
        int pick = helper(arr , index , amount , curr_amount + arr[index]);
        int skip = helper(arr , index  +1, amount , curr_amount );

        return dp[index][curr_amount] = pick + skip;
    }
}