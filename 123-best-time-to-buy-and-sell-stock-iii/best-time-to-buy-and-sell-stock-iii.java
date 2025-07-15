class Solution {
    public int maxProfit(int[] arr) {
        
        int n = arr.length;

        int[] left = new int[n];

       int minprice = arr[0];
        for(int i = 1 ;i < n  ; i++){
          minprice = Math.min(minprice , arr[i] );
          left[i] = Math.max(left[i-1] ,  arr[i] - minprice);
        }

        int right[] = new int[n];

        int maxprice = arr[n-1];

        for(int i = n -2 ; i >= 0 ; i--){
            maxprice = Math.max(maxprice , arr[i]);
            right[i] = Math.max(right[i+1] , maxprice - arr[i]);
        }

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans , left[i] + right[i]);
        }

        return ans;
    }
}