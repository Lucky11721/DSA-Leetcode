class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] < k) ans++;
            int product = arr[i];
            for (int j = i +1 ; j < n; j++) {
                product *= arr[j];
                if (product < k) {
                    ans++;
                }
                else if(product >= k) break;
            }
        }
        return ans;
    }
}