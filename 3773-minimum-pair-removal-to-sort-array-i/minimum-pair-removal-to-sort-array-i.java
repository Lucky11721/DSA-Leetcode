import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {

        if (nums.length <= 1) return 0;

        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int ans = 0;

        // repeat until array becomes sorted
        while (!isSorted(list)) {

            int index = minPairIndex(list);

            int mergedValue = list.get(index) + list.get(index + 1);

            list.set(index, mergedValue);
            list.remove(index + 1);

            ans++;
        }

        return ans;
    }

    // returns true ONLY if array is sorted
    boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // returns index of adjacent pair with minimum sum
    int minPairIndex(List<Integer> list) {
        int minSum = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        return index;
    }
}
