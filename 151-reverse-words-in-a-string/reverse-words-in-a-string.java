class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (s.charAt(j) != ' ') {
                j++;
            } else if (s.charAt(i) == ' ') {
                i++;
                j++;
            } else {
                String str = s.substring(i, j);
                sb.append(rev(str, 0, str.length() - 1));
                sb.append(" ");
                i = j + 1;
                j = i;
            }
        }
        String str = s.substring(i, j);
        sb.append(rev(str, 0, str.length() -1));

        sb.reverse();

        return sb.toString();

    }

    public String rev(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);

        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
}