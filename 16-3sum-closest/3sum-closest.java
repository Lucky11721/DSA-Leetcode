class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        int closestSum = arr[0] + arr[1] + arr[2]; // initialize with first 3 sum

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    // if this sum is closer to target, update closestSum
                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
}
