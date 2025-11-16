class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int row = 0;
        for(int col = 0 ; col < n  ; col++){
            if(board[row][col] == 'O'){
                dfs(board , m , n , row , col);
            }
        }
         row = m-1;
        for(int col = 0 ; col < n  ; col++){
            if(board[row][col] == 'O'){
                dfs(board , m , n , row , col);
            }
        }
        int col = 0;
        for(int r = 0 ; r < m  ; r++){
            if(board[r][col] == 'O'){
                dfs(board , m , n , r , col);
            }
        }
         col = n-1;
         for(int r = 0 ; r < m  ; r++){
            if(board[r][col] == 'O'){
                dfs(board , m , n , r , col);
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j  = 0 ; j < n ; j++){
                if(board[i][j]=='#') board[i][j] = 'O';
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board , int m , int n , int row , int col){
        board[row][col] = '#';

        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d : direction){
            int newRow  = row + d[0];
            int newCol = col + d[1];

            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol <  n && board[newRow][newCol] == 'O'){
                dfs(board , m , n , newRow , newCol);
            }
        }

    }
}