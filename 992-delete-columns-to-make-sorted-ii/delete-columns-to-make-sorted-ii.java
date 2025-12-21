class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int ans = 0;

        boolean[] alreadySorted = new boolean[n - 1];

        for (int j = 0; j < m; j++) {
            boolean bad = false;

            // check column
            for (int i = 1; i < n; i++) {
                char curr = strs[i].charAt(j);
                char prev = strs[i - 1].charAt(j);

                if (!alreadySorted[i - 1] && prev > curr) {
                    ans++;
                    bad = true;
                    break;
                }
            }

            if (bad) continue;

            // update sorted pairs
            for (int i = 0; i < n - 1; i++) {
                if (strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                    alreadySorted[i] = true;
                }
            }
        }
        return ans;
    }
}
