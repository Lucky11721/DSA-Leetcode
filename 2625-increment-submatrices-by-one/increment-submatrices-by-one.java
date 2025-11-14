class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];

        for(int[] query : queries){
            int  startRow = query[0];
            int endRow = query[2];
            int startCol = query[1];
            int endCol = query[3];

            for(int i = startRow ; i <= endRow ; i++){
                diff[i][startCol]+=1;
                if(endCol +1< n){
                    diff[i][endCol+1] -=1;
                }
            }
        }
        System.out.println(Arrays.deepToString(diff));
        for(int i = 0; i < n ; i++){
            for(int j = 1 ; j< n ; j++ ){
                diff[i][j] +=  diff[i][j-1];
            }
        }


return diff;
    }
}