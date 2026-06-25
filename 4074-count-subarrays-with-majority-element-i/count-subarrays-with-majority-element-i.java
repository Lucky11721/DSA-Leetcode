class Solution {
    public int countMajoritySubarrays(int[] arr, int target) {
        int n = arr.length;
        int ans = 0;

          for (int start = 0; start < n; start++) {
              int count = 0;
            for (int end = start; end < n; end++) {
                if(arr[end] == target) count++;
                int len = (end - start +1);
                if(count > len/2) ans++;
            }
        }

        return ans;
    }
}