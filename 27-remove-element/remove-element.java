class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i< n ; i++){
            if(nums[i] != val){
                ans.add(nums[i]);
            }
        }
        int count = 0;
        for(int i = 0 ;i < ans.size()  ; i++){
            nums[count] = ans.get(i);
            count++;
        }
        return count;
    }
}