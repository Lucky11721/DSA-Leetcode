class Solution {
    public int rob(int[] arr) {
        int[]  dp  = new int[arr.length *2];
        Arrays.fill(dp,-1);
        int max0 = maxrob(arr , 0 , dp);
        int max1 = maxrob(arr ,1 , dp);

        return Math.max(max0 , max1);
    }

    public int maxrob(int[] arr , int index , int[] dp){
    if(index == arr.length || index == arr.length +1 ||  index == arr.length +2) return 0;
    if(dp[index] != -1) return dp[index];

    int min = arr[index] + Math.max(maxrob(arr , index + 2 , dp) , maxrob(arr , index+3 , dp));
    dp[index] = min;
    return min;

    }
}