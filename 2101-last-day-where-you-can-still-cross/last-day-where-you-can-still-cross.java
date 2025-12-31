class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
     
     
        int ans = 0;

        int start =0;
        int  end = cells.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canCross(cells , row , col , mid)){
                ans = mid+1;
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
             
      
          return ans;
    }

    public boolean canCross(int[][] cells , int row , int col , int mid){
        int[][] grid = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for(int i = 0 ; i <= mid ; i++ ){
            int x = cells[i][0]-1;
            int y = cells[i][1] -1;
            grid[x][y] = 1;
            visited[x][y] = true;
        }
        for(int cols = 0 ; cols < col ; cols++ ){
            if(grid[0][cols] == 0 && visited[0][cols] == false){
                if(dfs(grid , 0 ,cols , visited)){
                    return true;
                }
            }
        }
        return false;
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