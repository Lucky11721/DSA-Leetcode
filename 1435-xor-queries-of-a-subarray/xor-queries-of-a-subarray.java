class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;

        int m = queries.length;

        int[] pre = new int[n];

        pre[0] = arr[0];

        for(int i = 1 ; i  < n ; i++){
            pre[i] = arr[i] ^pre[i-1];
        } 

        int ans[] = new int[m];

        for(int i = 0; i < m ; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0) ans[i] = pre[end];
            else  ans[i] = pre[end] ^ pre[start-1];
        }
        return ans;
    }
}