class Solution {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int[] ans = {-1, -1};

        // Find the lower bound
        int start = 0;
        int end = n - 1;
        int lb = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                // If mid is the start of the target range or no more lower elements match target
                if (mid > 0 && arr[mid] == arr[mid - 1]) {
                    end = mid - 1;
                } else {
                    lb = mid;
                    break;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Find the upper bound
        start = 0;  // Reset start for the second search
        end = n - 1;  // Reset end for the second search
        int ub = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                // If mid is the end of the target range or no more upper elements match target
                if (mid + 1 < n && arr[mid] == arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    ub = mid;
                    break;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Update the answer array
        ans[0] = lb;
        ans[1] = ub;

        return ans;
    }
}
