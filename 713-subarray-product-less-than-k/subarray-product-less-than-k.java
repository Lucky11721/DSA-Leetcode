class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length;

        int ans = 0;

       for(int i = 0 ;  i< n ; i++){
        if(arr[i] >= k ) continue;
        int product  =1;
        for(int j = i ; j < n ; j++){
            product = product*arr[j];
            if(product < k) ans++;
            else if(product > k) break;
        }
       }
        return ans;
    }
}