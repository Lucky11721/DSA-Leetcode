class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count= 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0 ) count++;
        }
        int ans = 0;

        for(int i = 0 ; i < n  ; i++){
            if(nums[i] == 0){
                if(isValid(nums , i , -1 , count)) ans++;
                 if(isValid(nums , i , 1 , count)) ans++;
            }
        }

        return ans;
    }

    public boolean isValid(int[] nums , int curr , int direction , int count){
        int[] arr = nums.clone();

        int index = curr;

        while(index >= 0 && index < arr.length && count > 0){
            if(arr[index] > 0){
                arr[index]--;
                direction *= -1;

                if(arr[index] == 0) count--;
            }

            index += direction;
        }

        return count == 0;
    }
}