class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }
        }

        return index; // new length
    }
}
