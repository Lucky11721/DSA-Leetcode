class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int ans = 0;
        int left = 0;
        int right = n*n -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            boolean[][] visited = new boolean[n][n];
            if(dfs(grid , 0, 0 , n , mid , visited)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid +1;
            }
        }
        return ans;
    }

    public boolean dfs(int[][] grid , int i , int j , int n , int time , boolean[][] visited){
        if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] == true || grid[i][j] > time){
            return false;
        }

        visited[i][j] = true;
        int[][] directions = {{-1,0} , {1,0} , {0,1} , {0,-1}};

        if(i == n-1 && j == n-1 ) return true;
        for(int[] direc : directions){
            int curr_i = i + direc[0];
            int curr_j = j + direc[1];

            if(dfs(grid ,  curr_i , curr_j , n , time , visited)){
                return true;
            }
        }
        return false;

    }
}