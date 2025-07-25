import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums); // Sort the array

        int smallestPositive = 1;

        for (int num : nums) {
            if (num == smallestPositive) {
                smallestPositive++;
            }
        }

        return smallestPositive;
    }
}
