class Solution {
    int[][] dp;
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalPacks = 0;

        for(int pack : apple){
            totalPacks += pack;
        }
        int totalCapacity = 0;
        for(int cap : capacity){
            totalCapacity += cap;
        }
        dp = new int[capacity.length][totalCapacity+1];

        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
       

        return helper(capacity , 0 , 0 , totalPacks);
    }


    public int helper(int[] arr , int index  , int curr_capacity , int limit){
       if (curr_capacity >= limit) return 0;

        if (index >= arr.length) return (int)1e9;

        if(dp[index][curr_capacity] != -1) return dp[index][curr_capacity];
        int pick = 1 + helper(arr , index+1 , curr_capacity + arr[index] , limit);
        int skip = helper(arr , index+1 , curr_capacity , limit);

        return dp[index][curr_capacity] = Math.min(pick , skip);
    }
}