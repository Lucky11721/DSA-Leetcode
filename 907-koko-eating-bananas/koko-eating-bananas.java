class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long curr_hour = 0;
            for (int pile : piles) {
                curr_hour += (pile + mid - 1) / mid;
            }

            if (curr_hour <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
