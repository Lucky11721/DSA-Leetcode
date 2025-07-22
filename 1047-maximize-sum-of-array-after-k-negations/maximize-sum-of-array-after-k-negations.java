class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);

        int i = 0;
        while (i < n) {
            if (arr[i] >= 0 || k == 0) {
                break;
            } else {
                arr[i] = arr[i] * -1;
            }
            i++;
            k--;
        }

        Arrays.sort(arr);
        if (k > 0) {

            while (k > 0) {
                arr[0] = arr[0] * -1;
                k--;
            }
        }

        int sum = 0;

        for (int x = 0; x < n; x++) {
            sum += arr[x];
        }

        return sum;

    }
}