class Solution {
    class Pair {
        int time;
        int row;
        int col;

        Pair(int time , int row , int col){
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.time , b.time));

        minHeap.add(new Pair(grid[0][0] , 0 , 0));

        int[][] directions = {{-1,0} , {1,0} , {0 ,-1} , {0,1}};

        while(minHeap.isEmpty() == false){
            Pair p = minHeap.remove();
            int time = p.time;
            int row = p.row;
            int col = p.col;
            visited[row][col] = true;
            if(row == n-1 && col == n-1){
                return time;
            }

            for(int[] direc : directions){
                int curr_row = row + direc[0];
                int curr_col = col + direc[1];

                if(curr_row >= 0 && curr_col >= 0 && curr_row < n && curr_col < n
                 && visited[curr_row][curr_col] == false){
                    minHeap.add(new Pair(Math.max(grid[curr_row][curr_col] ,time) , curr_row , curr_col));
                 }
            }
        }

        return 0;
    }
}