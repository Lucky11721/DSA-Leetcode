class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int ans = 0;

        for (int num : nums) {
            ans += (num - min);
        }

        return ans;
    }
}
