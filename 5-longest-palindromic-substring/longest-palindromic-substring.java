class Solution {
    String ans;
    Boolean[][] isPalDp;   // DP for palindrome validity
    boolean[][] seen;     // DP to prune recursion states

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;

        ans = "";
        isPalDp = new Boolean[n][n];
        seen = new boolean[n][n];

        helper(s, 0, n - 1);

        if (ans.equals("")) {
            return String.valueOf(s.charAt(0));
        }
        return ans;
    }

    public void helper(String s, int i, int j) {
        if (i > j) return;

        // 🔥 Critical DP pruning (prevents TLE)
        if (seen[i][j]) return;
        seen[i][j] = true;

        if (isValid(s, i, j)) {
            if (j - i + 1 > ans.length()) {
                ans = s.substring(i, j + 1);
            }
            return;
        }

        helper(s, i + 1, j);
        helper(s, i, j - 1);
    }

    public boolean isValid(String s, int i, int j) {
        if (i >= j) return true;

        if (isPalDp[i][j] != null) {
            return isPalDp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return isPalDp[i][j] = false;
        }

        return isPalDp[i][j] = isValid(s, i + 1, j - 1);
    }
}
