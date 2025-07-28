class Solution {
    public int firstMissingPositive(int[] arr) {

        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }

        int smallest = 1;
        int i = 0;
        while (i < n) {
            if (set.contains(smallest)) {
                smallest++;
            }
            i++;
        }
        return smallest;

    }
}