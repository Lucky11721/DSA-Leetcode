class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        // first loop make negative value 0
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
               arr[i] = 0;
            }
        }
        // 2 loop start marking visited element or marked present in array by making the value of array -1 index  = -ve

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if( val >= 1 && val <= n){
                int index = val -1;
                if(arr[index] > 0){
                    arr[index] = -1 *arr[index];
                }
                else if(arr[index] == 0){
                    arr[index] = -1*(n+1);
                }
            }

            
                
        }

       

        for (int i = 1; i <=n; i++) {
            int index = i - 1;
            if(arr[index] >= 0 ) return i;
            
        }

        return n +1 ;
    }
}