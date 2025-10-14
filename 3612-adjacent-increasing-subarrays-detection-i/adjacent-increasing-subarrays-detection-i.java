class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (k == 1) return true;

        // Special case: exactly 2*k elements
        if (n == 2 * k) {
            return helper(nums, 0, k, k, 2 * k, k);
        }

        // General case: sliding over possible positions
        for (int i = 0; i + 2 * k <= n; i++) {
            if (helper(nums, i, i + k, i + k, i + 2 * k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(List<Integer> list, int i, int j, int ik, int jk, int k) {
        int count = 0;

        // first subarray [i, j)
        for (int x = i + 1; x < j; x++) {
            if (list.get(x) > list.get(x - 1)) {
                count++;
            } else {
                return false; // not strictly increasing
            }
        }

        // second subarray [ik, jk)
        for (int x = ik + 1; x < jk; x++) {
            if (list.get(x) > list.get(x - 1)) {
                count++;
            } else {
                return false; // not strictly increasing
            }
        }

        // both must be strictly increasing
        return count == 2 * (k - 1);
    }
}
