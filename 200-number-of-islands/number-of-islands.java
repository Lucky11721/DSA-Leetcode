class Solution {
    public int numIslands(char[][] grid) {
        
        int m =  grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        int count =0;
        for(int i = 0 ; i <  m ; i++){
            for(int j = 0 ; j< n ; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    dfs(grid , i , j , visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid , int row , int col , boolean[][] visited){

        visited[row][col] = true;

        int[] dx = {1 , 0 , -1 , 0};

        int[] dy = {0 , 1 , 0 , -1};

        for(int i = 0 ; i < 4 ; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newRow < grid.length  && newCol >= 0 && newCol <
             grid[0].length && grid[newRow][newCol] == '1' && visited[newRow][newCol] == false){
                dfs(grid , newRow , newCol , visited);
             }
        }
    }
}