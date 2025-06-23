class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int dp[] = new int[cost.length +1];
        Arrays.fill(dp ,-1);
        int min0 = mincost(cost , 0 , dp);
        int min1 = mincost(cost , 1,dp);
       
        return Math.min(min0 , min1);

    }

    public int mincost(int[] cost , int index , int[] dp){
    if(index == cost.length || index == cost.length +1) return 0;
    if(dp[index] != -1) return dp[index];

    int min = cost[index] + Math.min(mincost(cost , index + 1 , dp) , mincost(cost , index+2 , dp));
    dp[index] = min;
    return min;

    }
}