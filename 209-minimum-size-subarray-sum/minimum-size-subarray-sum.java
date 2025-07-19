class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int minSize = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;

        // First window expansion until sum >= target
        while (j < n && sum < target) {
            sum += arr[j];
            j++;
        }

        // Main loop: sliding the window
        while (i < n) {
            if (sum >= target) {
                minSize = Math.min(minSize, j - i); // (j - i) is length
                sum -= arr[i];
                i++;
            } else if (j < n) {
                sum += arr[j];
                j++;
            } else {
                break;
            }
        }

        return (minSize == Integer.MAX_VALUE) ? 0 : minSize;
    }
}
