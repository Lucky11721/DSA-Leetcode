class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (checkpal(s, i, j) == true && (j - i + 1) > maxlen) {
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(start,start +  maxlen);

    }

    public boolean checkpal(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
