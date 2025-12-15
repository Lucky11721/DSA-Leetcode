class Solution {
    public long getDescentPeriods(int[] prices) {
         // dp 

         int n = prices.length;

         long ans = 1;

         long prev = 1;

         for(int i = 1 ; i < n ; i++){
            if(prices[i-1] == prices[i] +1) prev++;
            else prev = 1;
            ans += prev;
         }


         return ans;
    }
}