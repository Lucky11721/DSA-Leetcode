import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int[] arr = new int[n];
        
        // Convert list to array
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }

        Arrays.sort(arr); // Sort the array
        int count = 0;

        // For each element, binary search the highest j such that arr[i] + arr[j] < target
        for (int i = 0; i < n - 1; i++) {
            int low = i + 1, high = n - 1;
            int res = i;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[i] + arr[mid] < target) {
                    res = mid; // mid is a valid pair
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            count += (res - i); // number of valid j's for current i
        }

        return count;
    }
}
