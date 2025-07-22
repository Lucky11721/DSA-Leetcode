class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        for(int ele : nums){
            if( ele > 0 && !set.contains(ele -1)){
                return ele -1;
            }
        }
        return n;


    }
}