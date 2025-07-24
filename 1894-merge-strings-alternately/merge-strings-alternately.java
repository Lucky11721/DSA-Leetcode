class Solution {
    public String mergeAlternately(String word1, String word2) {

        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int i = 0;
        int j = 0;
        String ans = "";
        while (i < s1.length && j < s2.length) {
            if (i < s1.length) {
                ans += s1[i];
            }
            if(j <  s2.length){
            ans += s2[j];
            }
            
            i += 1;
            j += 1;
            if (i == s1.length) {
                ans += word2.substring(j, s2.length);
            }
            if (j == s2.length) {
                ans += word1.substring(i, s1.length);
            }
        }

        return ans;
    }
}