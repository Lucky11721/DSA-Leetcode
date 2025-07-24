class Solution {
    public int[] getConcatenation(int[] arr) {
        int n = arr.length;

        int[] ans = new int[2*n];


        for(int i = 0 ; i < 2*n ; i++){
           int index =  i% n;

           ans[i] = arr[index];


        }
        return ans;
    }
}