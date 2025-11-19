class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;

        int[] orders = new int[26];

        for (int i = 0; i < 26; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            int k = 0;
            boolean decided = false;

            while (k < w1.length() && k < w2.length()) {

                char c1 = w1.charAt(k);
                char c2 = w2.charAt(k);

                if (c1 == c2) {
                    k++;
                    continue;
                }

                if (orders[c1 - 'a'] > orders[c2 - 'a'])
                    return false;  // wrong order

                decided = true;   // correct order for this pair
                break;
            }

            // If not decided and prefix issue occurs
            if (!decided && w1.length() > w2.length())
                return false;
        }

        return true;
    }
}
