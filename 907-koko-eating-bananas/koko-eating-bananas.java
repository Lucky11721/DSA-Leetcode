class Solution {
    public int minEatingSpeed(int[] arr, int h) {

        int n = arr.length;
        int max_value = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > max_value) {
                max_value = arr[i];
            }
        }

        int left = 1;
        int right = max_value;

        int ans = right;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            long curr_hour = 0;
            for (int i = 0; i < n; i++) {
                double div = (double)arr[i]/mid;
                curr_hour += Math.ceil(div);
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