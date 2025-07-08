import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;
        long maxSum = 0;
        long windowSum = 0;
        Set<Integer> st = new HashSet<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            // Remove duplicate or adjust window if duplicate found
            while (st.contains(arr[right])) {
                windowSum -= arr[left];
                st.remove(arr[left]);
                left++;
            }

            st.add(arr[right]);
            windowSum += arr[right];

            // If window size reaches k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);

                // Shrink the window from left to slide it
                windowSum -= arr[left];
                st.remove(arr[left]);
                left++;
            }
        }

        return maxSum;
    }
}
