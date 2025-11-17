class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        int n = nums.length;
        int i =0;
        while(i < n){
            if(nums[i] == 1){
                if(prev != -1){
                    if(i - prev -1 < k ) return false;
                }

                prev = i;
            }
            i++;
        }
        return true;
    }
}