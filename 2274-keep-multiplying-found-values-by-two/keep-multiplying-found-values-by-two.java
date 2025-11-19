class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % original == 0) set.add(nums[i]);
            if(nums[i] == original){
                original *= 2;
                while(set.contains(original) == true){
                    original *= 2;
                }
            }
        }

        return original;
    }
}