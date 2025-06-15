class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sb.append(ch);

            if (ch == ' ') {
                reverse(sb, j, sb.length() - 2); // reverse the word before space
                j = sb.length(); // next word starts after the space
            }
        }

        // Reverse the last word
        reverse(sb, j, sb.length() - 1);

        return sb.toString();
    }

    public void reverse(StringBuilder str, int i, int j) {
        while (i < j) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}
