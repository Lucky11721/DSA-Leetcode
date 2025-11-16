class Solution {
    final int MOD = 1000000007;

    public int numSub(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0;
        long ans = 0;

        while (i < n) {
            if (ch[i] == '0') {
                i++;
                continue;
            }

            int j = i;
            while (j < n && ch[j] == '1') {
                j++;
            }

            int len = j - i;
            ans = (ans + (long)len * (len + 1) / 2) % MOD;

            i = j;
        }

        return (int)ans;
    }
}
