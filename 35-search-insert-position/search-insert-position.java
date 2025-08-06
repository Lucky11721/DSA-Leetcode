class Solution {
    public int searchInsert(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
     int n = nums.length;
        for(int i = 0 ; i < n ; i++){
             list.add(nums[i]);
        }
        list.add(target);

        Collections.sort(list);

        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) == target){
                return i;
            }
        }
        return 0;
    }
}