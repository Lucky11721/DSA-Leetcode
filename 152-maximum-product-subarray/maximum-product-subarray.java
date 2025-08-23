class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ;i < n ; i++){
            int curr_ans = 1;
            for(int j = i ; j < n ; j++){
              curr_ans *= arr[j];
              ans = Math.max(ans , curr_ans);
            }
        }
        return ans;
        
    }
}