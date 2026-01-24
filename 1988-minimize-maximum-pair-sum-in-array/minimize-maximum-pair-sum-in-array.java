class Solution {
    public int minPairSum(int[] nums) {
        int ans = 0;
        int n = nums.length;

        Arrays.sort(nums);

        int i = 0 ;
        int j = n-1;

        while(i <  j){
            int pair = nums[i] + nums[j];
            ans = Math.max(ans , pair);
            i++;
            j--;
        }

     
        return ans;
    }
}