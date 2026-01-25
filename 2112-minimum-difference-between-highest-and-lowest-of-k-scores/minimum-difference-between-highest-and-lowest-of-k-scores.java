class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int i = 0;
        int j = k-1;

        while(j < nums.length){
            int highest = nums[j];
            int lowest = nums[i];
            ans = Math.min(ans , highest - lowest);
            i++;
            j++;
        }

        return ans;
        
    }
}