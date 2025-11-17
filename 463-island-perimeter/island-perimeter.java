class Solution {
    class Pair{
        int row , col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    int ans = 0;
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m  ; i++){
            for(int j  = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    bfs(grid , m , n , i , j , visited);
                }
            }
        }
        System.out.println(Arrays.deepToString(visited));


        return ans;
    }
    public void bfs(int[][] grid ,  int m , int n , int row ,  int col , boolean visited[][]){

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(row , col));
        visited[row][col] = true;

        while(que.isEmpty() == false){

            Pair p = que.remove();
            int[] dx = {1, 0 , -1 ,0};
            int[] dy = {0 , 1 , 0 ,-1};
            for(int i = 0 ; i < 4 ; i++){
            int newRow = p.row + dx[i];
            int newCol = p.col + dy[i];

            if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) ans+=1;
            else{
                if(grid[newRow][newCol] == 0) ans++;
                else if(grid[newRow][newCol] == 1 && visited[newRow][newCol] == false){
                    que.add(new Pair(newRow , newCol));
                    visited[newRow][newCol] = true;
                }
            }

        }
    }
    }
}
