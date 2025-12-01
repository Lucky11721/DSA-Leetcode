class Solution {
    public long maxRunTime(int n, int[] arr) {

        long total = 0;
        for (int capacity : arr) total += capacity;

        long left = 0;
        long right = total / n;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (possible(arr, mid, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] arr, long mid, int n) {
        long target = mid * n;
        long sum = 0;

        for (int x : arr) {
            sum += Math.min(x, mid);
            if (sum >= target) return true;
        }
        return false;
    }
}
