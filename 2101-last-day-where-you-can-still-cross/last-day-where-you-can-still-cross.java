class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int start = 0, end = cells.length - 1;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canCross(cells, row, col, mid)) {
                ans = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public boolean canCross(int[][] cells, int row, int col, int mid) {
        int[][] grid = new int[row][col];

        // flood cells
        for (int i = 0; i <= mid; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1; // water
        }

        // try all top-row columns
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                if (dfs(grid, 0, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int r, int c) {
        if (r == grid.length - 1) return true;

        // mark as visited
        grid[r][c] = -1;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < grid.length &&
                nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] == 0) {

                if (dfs(grid, nr, nc)) return true;
            }
        }
        return false;
    }
}
