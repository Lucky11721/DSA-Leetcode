class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row  , int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][]  = new boolean[m][n];
        Queue<Pair> que = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j  = 0 ; j <  n ;j++){
                if(grid[i][j] == 2){
                    que.add(new Pair(i,j));
                    visited[i][j]  = true;
                }
                if(grid[i][j] == 1) freshOrange++;
            }
        }
        int min = 0;
        while(que.isEmpty() == false){
            int size = que.size();
            while(size  > 0){
                Pair p = que.remove();
                size--;
                int row = p.row;
                int col = p.col;
                int[] dx = {1 , 0 , -1 ,0};
                int[] dy = {0 , 1 , 0 ,-1};
                for(int i = 0 ; i < 4 ; i++){
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];
                    if(newRow >=  0 && newCol >= 0 && newRow < m && newCol < 
                    n && visited[newRow][newCol] == false && grid[newRow][newCol] == 1){
                        que.add(new Pair(newRow , newCol));
                        visited[newRow][newCol] = true;
                        freshOrange--;
                    }
                }
            }
        min++;
        }

       if(freshOrange > 0 ) return -1;
       else if(min == 0 ) return 0;
       
       return min-1;
    }
}