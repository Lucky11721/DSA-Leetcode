class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int k = n/2;

        for(int i = 0 ; i < n ; i++){
            int curr = nums[i];
            int next = -1;
             if(i+1 < n){
                next = nums[i+1];
             }
             int nextOfnext = -1;
             if(i+2 < n){
                nextOfnext = nums[i+2];
             }
             int next3 = -1;
             if(i+3 < n){
                next3 = nums[i+3];
             }

           
            if(curr == next || (curr == nextOfnext) || curr == next3) return curr;
        }

        return -1;
    }
}