class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
          Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // shorter number is smaller
            } else {
                return a.compareTo(b); // same length, compare lexicographically
            }
        });
     System.out.println(Arrays.toString(nums));

        int pos  = n - k;

        int i =0;

        while(i < pos){
            i++;
        }
        return nums[i];
    }
}