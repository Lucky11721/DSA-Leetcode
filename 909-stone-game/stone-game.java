class Solution {
    public boolean stoneGame(int[] piles) {
        int[] dp = new int[piles.length +1 ];
        Arrays.fill(dp , -1);
        int alice = helper(piles , 0 , dp);
        int bob = helper(piles , 1 ,dp);
    
        if(alice > bob)return true;

        return false;
    }
    public int helper(int[] arr , int index , int[] dp){
        if(index >= arr.length) return 0;
      if(dp[index] != -1) return dp[index];

        int pick = arr[index] + helper(arr , index+1 , dp);
        int skip = helper(arr , index+1 , dp);


        return dp[index] =  Math.max(pick , skip);
    }
}