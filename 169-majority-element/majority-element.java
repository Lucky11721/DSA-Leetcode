class Solution {
    public int majorityElement(int[] nums) {
        // use moore voting algorithm 

        int cand = -1;
        int count = 0;
        int n = nums.length;
        int ans = 0;
        for(int num : nums){
            if(num == cand ){
                count++;
            }
            else if(count == 0){
                cand = num;
                count = 1;
            }
            else{
                count--;
            }
        }
     return cand;
    }
}