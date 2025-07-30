class Solution {
    public int trap(int[] arr) {

        int n = arr.length;
        int curr_leftmax = 0;
        int[] leftmax = new int[n];

        for (int i = 0; i < n; i++) {
            leftmax[i] = curr_leftmax;

            if (arr[i] > curr_leftmax) {
                curr_leftmax = arr[i];
            }
        }

        int curr_rightmax = 0;

        int[] rightmax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightmax[i] = curr_rightmax;
            if (arr[i] > curr_rightmax) {
                curr_rightmax = arr[i];
            }
        }

        int[] minleft_right = new int[n];

        for (int i = 0; i < n; i++) {
            minleft_right[i] = Math.min(leftmax[i], rightmax[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (minleft_right[i] - arr[i] > 0) {
                result += (minleft_right[i] - arr[i]);
            }
        }
        return result;

    }
}