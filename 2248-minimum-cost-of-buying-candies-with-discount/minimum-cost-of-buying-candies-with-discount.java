class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;

        for (int i = n - 1; i >= 0; i--) {
            // skip every 3rd candy (free one)
            if ((n - i) % 3 != 0) {
                sum += cost[i];
            }
        }
        return sum;
    }
}
