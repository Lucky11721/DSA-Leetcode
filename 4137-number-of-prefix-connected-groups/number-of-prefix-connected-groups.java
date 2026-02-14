import java.util.*;

class Solution {
    public int prefixConnected(String[] words, int k) {
        Arrays.sort(words);

        int n = words.length;
        int count = 0;
        int i = 0;

        while (i < n) {
            if (words[i].length() < k) {
                i++;
                continue;
            }

            String prefix = words[i].substring(0, k);
            int j = i + 1;

            while (j < n && words[j].length() >= k &&
                   words[j].substring(0, k).equals(prefix)) {
                j++;
            }

            if (j - i > 1) count++;

            i = j;
        }

        return count;
    }
}
