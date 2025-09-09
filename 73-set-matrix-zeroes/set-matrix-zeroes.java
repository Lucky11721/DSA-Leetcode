class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[] rowzero = new boolean[n];
        boolean[] colzero = new boolean[m];

        for(int i = 0  ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == 0){
                    rowzero[i] = true;
                    colzero[j] = true;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(rowzero[i] == true){
                for(int x = 0 ; x < m ; x++){
                    arr[i][x] = 0;
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(colzero[i] == true){
                for(int x = 0 ; x < n ; x++){
                    arr[x][i] = 0;
                }
            }
        }
    }
}