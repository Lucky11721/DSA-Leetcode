class Solution {
    int[] dp;
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;

        dp = new int[n+1];

        Arrays.fill(dp , -1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i <  n ;  i++){

            ans = Math.max(ans , helper(energy , i , k));
        }

        return ans;
    }


    public int helper(int[] arr , int index , int k){
        if(index >= arr.length) return 0;
        if(dp[index] != -1) return dp[index];

        return dp[index] = arr[index] + helper(arr , index+k , k);
}

}