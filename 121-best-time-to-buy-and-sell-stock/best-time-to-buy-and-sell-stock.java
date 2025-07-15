class Solution {
    public int maxProfit(int[] arr) {
        return helper(arr, 0, Integer.MAX_VALUE, 0);
    }

    public int helper(int[] arr, int index, int minprice, int maxProfit) {
        if (index == arr.length) return maxProfit;

        if (arr[index] < minprice) {
            minprice = arr[index];
        } else {
            maxProfit = Math.max(maxProfit, arr[index] - minprice);
        }

        return helper(arr, index + 1, minprice, maxProfit);
    }
}
