class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
       int n = prices.length;
      
       long actualProfit = 0;
       long[] profit = new long[n];

       for(int i= 0 ; i < n ; i++){
        profit[i] = (long)(prices[i] * strategy[i]);
        actualProfit += profit[i];
       }

       long originalWindowProfit = 0;

       long modifiedWindowProfit = 0;

       long maxGain = 0;

       int i = 0; 
       int j = 0;
       while(j < n ){
        originalWindowProfit += profit[j];
          if(j-i+1 > k/2){
            modifiedWindowProfit += prices[j];
          }

          if(j-i+1 > k ){
           originalWindowProfit -= profit[i];
           modifiedWindowProfit -= prices[i + k/2];
           i++;
          }

          if(j - i +1 == k){
            maxGain = Math.max(maxGain , modifiedWindowProfit - originalWindowProfit);
          }
          j++;
       }

       return actualProfit + maxGain;
    }
}