class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices , 1 , 0);
    }
    public int helper(int[] arr , int index , int profit){
        if(index == arr.length) return profit;

        if(arr[index] > arr[index-1]){
            profit += arr[index] - arr[index-1];
        }

        return helper(arr , index +1 , profit);
    }
}