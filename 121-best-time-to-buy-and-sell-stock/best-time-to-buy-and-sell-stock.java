class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;

        int maxProfit = 0;
        int minprice = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            if(arr[i] < minprice){
                minprice = arr[i];
            }
            else{
                maxProfit = Math.max(maxProfit , arr[i] - minprice);
            }
        }

        return maxProfit;
    }
}