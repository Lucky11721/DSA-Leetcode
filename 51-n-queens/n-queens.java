

class Solution {
    List<List<String>> final_ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] ans = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = '.';
            }
        }

        System.out.println(Arrays.deepToString(ans));  // Fix: use deepToString to print 2D array
        helper(ans, 0, n);
        return final_ans;
    }

    public void helper(char[][] ans, int row, int n) {
        if (row >= n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String st = "";
                for (int j = 0; j < ans[0].length; j++) {
                  st += ans[i][j];
                }
                temp.add(st);
            }
            final_ans.add(new ArrayList<>(temp));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(ans, row, col)) {
                ans[row][col] = 'Q';
                helper(ans, row + 1, n);
                ans[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] ans, int row, int col) {
        int n = ans.length;

        // Upward column
        for (int i = row - 1; i >= 0; i--) {
            if (ans[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (ans[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (ans[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
