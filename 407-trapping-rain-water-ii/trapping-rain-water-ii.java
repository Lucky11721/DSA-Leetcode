
class Solution {
    class Pair{
        int height;
        int row;
        int col;

        Pair(int height , int row , int col){
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
    public int trapRainWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a.height ,b.height));
        boolean[][] visited = new boolean[n][m];
        int[][] direction = {{0,-1} , {0,1} , {-1,0} , {1,0}};

       for(int i = 0 ; i  < n ; i++){
        for(int j = 0 ; j  <m ; j++){
            if(i == 0 || i == n-1){
                minheap.add(new Pair(grid[i][j] , i , j));
                visited[i][j] = true;
            }
        }
       }
       for(int i = 0 ; i  < n ; i++){
        for(int j = 0 ; j  <m ; j++){
            if(j == 0 || j == m-1){
                minheap.add(new Pair(grid[i][j] , i , j));
                visited[i][j] = true;
            }
        }
       }
       System.out.println(Arrays.deepToString(visited));

       int water = 0;

       while(minheap.isEmpty() == false){

        Pair p = minheap.remove();
        int height = p.height;
        int i = p.row;
        int j = p.col;

        for(int[] arr : direction){
            int curr_i = i + arr[0];
            int curr_j = j + arr[1];

            if(curr_i >= 0 && curr_i < n && curr_j >= 0 && curr_j < m && visited[curr_i][curr_j] == false){
                int hold = height -grid[curr_i][curr_j];
                water += Math.max(hold , 0);

                minheap.add(new Pair(Math.max(grid[curr_i][curr_j] , height) , curr_i , curr_j));

                visited[curr_i][curr_j] = true;
            }

        }

       }
       System.out.println(Arrays.deepToString(visited));
       return water;

    }
}