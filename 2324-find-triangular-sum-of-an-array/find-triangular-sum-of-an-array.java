class Solution {
    public int triangularSum(int[] arr) {
        int n = arr.length  ;

        while( n > 1){
            int[] newarr = new int[arr.length-1];

            for(int i = 1; i < n ; i++){
                newarr[i-1] = (arr[i] + arr[i-1]) % 10;
            }
            arr = newarr;
            n = arr.length;
        }

        return arr[0];
        
    }
}