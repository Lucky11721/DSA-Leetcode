class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int numIslands(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1' && visited[i][j] == false) {
                    dfs(arr, i, j, visited, n, m);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] arr , int row, int col ,boolean[][] visited ,  int n , int m ){
      
        visited[row][col] =true;
        if(row -1 >= 0 && arr[row-1][col] == '1' && visited[row-1][col] == false){
            dfs(arr , row-1 , col , visited , n , m);
        }
         if(row +1 < n&& arr[row +1][col] == '1' && visited[row+1][col] == false){
            dfs(arr , row +1 , col , visited , n , m);
        }
         if(col -1 >= 0 && arr[row][col -1] =='1'&& visited[row][col-1] == false){
            dfs(arr , row , col-1 , visited , n , m);
        }
         if( col+1 < m &&  arr[row][col+1] == '1'&& visited[row][col+1] == false){
            dfs(arr , row , col+1 , visited , n , m);
        }
    }

    public void helper(char[][] arr, int rows, int cols, boolean[][] visited, int n, int m) {
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(rows, cols);
        que.add(p);
        visited[rows][cols] = true;

        while (!que.isEmpty()) {
            Pair index = que.remove();
            int row = index.row;
            int col = index.col;

            // Top-left corner (0,0)
            if (row == 0 && col == 0) {
                if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
                if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }

            // Top-right corner (0, m-1)
            else if (row == 0 && col == m - 1) {
                if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
                if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }

            // Bottom-left corner (n-1, 0)
            else if (row == n - 1 && col == 0) {
                if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
                if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }

            // Bottom-right corner (n-1, m-1)
            else if (row == n - 1 && col == m - 1) {
                if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
                if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }

            // Top edge (excluding corners)
            else if (row == 0 && col > 0 && col < m - 1) {
                if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
                if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
                if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
            }

            // Bottom edge (excluding corners)
            else if (row == n - 1 && col > 0 && col < m - 1) {
                if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
                if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
                if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
            }

            // Left edge (excluding corners)
            else if (col == 0 && row > 0 && row < n - 1) {
                if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
                if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
                if (col + 1 < m && arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }

            // Right edge (excluding corners)
            else if (col == m - 1 && row > 0 && row < n - 1) {
                if (row - 1 >= 0 && arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
                if (row + 1 < n && arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
                if (col - 1 >= 0 && arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }

            // Inner cells (not on edge or corner)
            if (row > 0 && col > 0 && row < n - 1 && col < m - 1) {
                if (arr[row - 1][col] == '1' && !visited[row - 1][col]) {
                    que.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
                if (arr[row][col - 1] == '1' && !visited[row][col - 1]) {
                    que.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
                if (arr[row + 1][col] == '1' && !visited[row + 1][col]) {
                    que.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
                if (arr[row][col + 1] == '1' && !visited[row][col + 1]) {
                    que.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }
        }
    }
}
