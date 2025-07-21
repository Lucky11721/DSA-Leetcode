class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;

        int zero = 0;
        int i = 0;
        int j = 0;

        int ans = Integer.MIN_VALUE;

        while(j < n){
          
          if(arr[j] == 0){
            zero++;
          }

          while(zero > k){
            if(arr[i] == 0){
                zero--;
            }
            i++;
          }

          ans = Math.max(ans , j - i +1 );   
          j++;
        }

        ans = Math.max(ans , j - i);
   
        return ans;
    }
}