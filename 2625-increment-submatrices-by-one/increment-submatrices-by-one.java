class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        int length = ans.length;
        int colLength = ans[0].length;

        for(int[] query : queries){
            int startRow = query[0];
            int startCol = query[1];
            int endRow = query[2];
            int endCol = query[3];

            for(int i = startRow ; i <=endRow  ; i++){
                for(int j = startCol ; j <= endCol ; j++){
                    ans[i][j] += 1;
                }
            }
        }


return ans;
    }
}