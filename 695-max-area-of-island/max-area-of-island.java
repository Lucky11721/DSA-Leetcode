class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m  ; i++){
            for(int j = 0 ; j < n ; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                   
                    ans = Math.max(ans ,  dfs(grid , m , n , visited , i , j));
                }
            }
        }
       return ans;
    }

    public int dfs(int[][] grid ,int m , int n, boolean[][] visited , int row , int col ){

        visited[row][col] = true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int area =1;
        for(int i = 0  ; i < 4 ; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && visited[newRow][newCol] == false){
               area +=  dfs(grid , m , n , visited , newRow , newCol);
            }
        }
        return area;
    }

}