class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n+1][n+1][2];

        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < n+1 ; j++ ){
                for(int k = 0; k < 2 ; k++){
                    dp[i][j][k] = -2;
                }
            }
        }
        return helper(1 , 0 , 1 , piles);

    }

    public int helper(int person , int index , int M , int [] arr){
        if(index >= arr.length) return 0;
        if( dp[index][M][person] != -2) return  dp[index][M][person];

        int stone = 0;
        int ans = -1;
        if(person == 0) ans = Integer.MAX_VALUE;


        for(int i =1 ; i <= Math.min(2*M , arr.length - index) ; i++){
            
            if(person == 1){
                stone += arr[index + i -1]; 
                ans = Math.max(ans , stone + helper(0 , index + i , Math.max(M ,i) , arr));
            }
            else{
                ans = Math.min(ans , stone + helper(1 , index + i , Math.max(M , i) , arr));
            }
        }
        return dp[index][M][person] =   ans;
    }
}