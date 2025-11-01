class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;

        int[] target = new int[n];
        Arrays.fill(target , -1);
        for(int i = 0 ; i < n ; i++){
            int value = nums[i];
            int insert_index = index[i];
            if(target[insert_index] == -1){
                target[insert_index] = value;
            }
            else{
               int val = target[insert_index];
               target[insert_index]  = value;
               for(int j = insert_index +1 ;j < n ; j++){
                int temp_val = target[j];
                target[j] = val;
                val = temp_val;
               }
            }
 
        }

        return target;
    }

}