class Solution {
    public void moveZeroes(int[] arr) {
         int n = arr.length;
         int[] ans = new int[n];
      int index = 0;
         for(int i = 0 ; i <  n ; i++){

            if(arr[i] != 0){
                ans[index++] = arr[i];
            }
         }
         for(int i = index ; i < n ; i++){
         ans[i] = 0;  
         }

         for(int i =0 ;i <  n ; i++){
            arr[i] = ans[i];
         }
    }
}