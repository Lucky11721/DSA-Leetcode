class Solution {
    public int[] shuffle(int[] nums, int n) {
        int temp_n = n;
        int index = 0;
        while(temp_n != 0){
     index++;
     temp_n--;
        }

        int i = 0;
        int[] ans = new int[2*n];
        int ans_index =0;
        while(i < n && index < 2*n){
         ans[ans_index] = nums[i];
         ans_index++;
         ans[ans_index] = nums[index];
           ans_index++;
           i++;
           index++;

        }

        return ans;
        
    }
}