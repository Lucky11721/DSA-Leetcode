class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int k = n/2;

       HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            int ele = nums[i];

            if(set.contains(ele)){
                return ele;
            }

            set.add(ele);
        }


        return -1;
    }
}