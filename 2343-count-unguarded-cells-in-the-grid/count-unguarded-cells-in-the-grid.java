class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for(int[] g : guards){
            int row = g[0];
            int col  = g[1];
            grid[row][col] = 1;
        }
        for(int[] w : walls){
            int row = w[0];
            int col = w[1];
            grid[row][col] = -1;
        }

        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

        for(int[] guard : guards){
            int row = guard[0];
            int col = guard[1];

            movement(row , col , grid , m , n);
        }

        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j =  0; j < n ; j++){
                if(grid[i][j] == 0) ans++;
            }
        }
        return ans;
    }

    public void movement(int row , int col ,int[][] grid , int m , int n){

       // up 
       int new_row = row -1;
       while(new_row >= 0 && grid[new_row][col] != -1 && grid[new_row][col] != 1){
          if(grid[new_row][col] == 0){
            grid[new_row][col] = 2;
          }
          new_row--;
       }
       //down
        new_row = row +1;
        while(new_row < m  && grid[new_row][col] != -1 && grid[new_row][col] != 1){
          if(grid[new_row][col] == 0){
            grid[new_row][col] = 2;
          }
          new_row++;
       }
       //left
       int new_col = col-1;
        while(new_col >= 0 && grid[row][new_col] != -1 && grid[row][new_col] != 1){
          if(grid[row][new_col] == 0){
            grid[row][new_col] = 2;
          }
          new_col--;
       }
       // right
        new_col = col +1;
        while(new_col < n && grid[row][new_col] != -1 && grid[row][new_col] != 1){
          if(grid[row][new_col] == 0){
            grid[row][new_col] = 2;
          }
          new_col++;
       }

    }
}