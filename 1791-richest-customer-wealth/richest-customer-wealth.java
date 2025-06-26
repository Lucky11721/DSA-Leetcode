class Solution {
    public int maximumWealth(int[][] arr) {
        int n = arr.length;
        
        int ans[] = new int[n];

        for(int  i = 0 ;i < n  ;i++){
            int sum = 0 ;
            for(int j = 0; j  < arr[i].length ; j++){
                sum = sum + arr[i][j];
            }
            ans[i] = sum;
        }
        Arrays.sort(ans);

        return ans[n-1];
    }
}