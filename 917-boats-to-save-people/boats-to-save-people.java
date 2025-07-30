class Solution {
    public int numRescueBoats(int[] arr, int limit) {
          int n = arr.length;
          Arrays.sort(arr);

          int i  = 0 ;
          int j = n-1;
          int ans  =0 ;


          while(i <= j){
            if(arr[i] + arr[j] <= limit){
                i++;
                j--;
                ans++;
            }
            else{
                j--;
                ans++;
            }
            
          }
          return ans;
    }
}