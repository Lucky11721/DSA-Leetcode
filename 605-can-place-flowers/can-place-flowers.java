class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0) {

                int prev;
                if (i == 0) {
                    prev = 0;          // no previous element, treat as empty
                } else {
                    prev = flowerbed[i - 1];
                }

                int next;
                if (i == m - 1) {
                    next = 0;          // no next element, treat as empty
                } else {
                    next = flowerbed[i + 1];
                }

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;  // plant flower here
                    n--;
                    if (n == 0) {
                        return true;   // planted all, can exit early
                    }
                }
            }
            // else: spot already occupied, skip automatically
        }

        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
