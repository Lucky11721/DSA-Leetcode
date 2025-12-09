class Solution {
    int MOD = 1000000007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> right = new HashMap<>();
        for (int x : nums) right.put(x, right.getOrDefault(x, 0) + 1);

        HashMap<Integer, Integer> left = new HashMap<>();

        long ans = 0;

        for (int j = 0; j < n; j++) {

            int mid = nums[j];

            // remove from right FIRST
            right.put(mid, right.get(mid) - 1);
          

            // the value that i and k must have
            int target = mid * 2;

            if (left.containsKey(target) && right.containsKey(target)) {
                long cntLeft = left.get(target);
                long cntRight = right.get(target);
                ans = (ans + (cntLeft * cntRight) % MOD) % MOD;
            }

            // add mid to left AFTER
            left.put(mid, left.getOrDefault(mid, 0) + 1);
        }

        return (int) ans;
    }
}
