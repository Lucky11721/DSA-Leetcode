class Solution {
    public int latestDayToCross(int row, int cols, int[][] cells) {
        int[][] grid = new int[row][cols];
     
        int ans = 0;
        for(int day = 0 ; day < cells.length ; day++){
            int x = cells[day][0] -1;
            int y = cells[day][1] -1;
            grid[x][y] = 1;
            boolean canReachEnd = false;
            boolean[][] visited = new boolean[row][cols];
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[0][col] == 0 &&visited[0][col] == false){
                     if(dfs(grid , 0 , col , visited)){
                      canReachEnd = true;
                      break;
                     }
                     
            
                }
              

            }
             
            if(!canReachEnd) return day;
            
           
        }
          return ans;
    }

    public boolean dfs(int[][] grid ,int row , int col ,  boolean[][] visited){
        if(row == grid.length-1) return true;

        visited[row][col] = true;

        int[] dx = {1 , 0 , -1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        for(int i = 0 ; i < 4 ; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newRow <grid.length && newCol >= 0 && newCol < grid[0].     length &&  grid[newRow][newCol] == 0 && visited[newRow][newCol] == false ){
                if(dfs(grid , newRow , newCol , visited)) return true;
            }
        }

        return false;
    }
}