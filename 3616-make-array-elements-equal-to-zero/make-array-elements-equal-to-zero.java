class Solution {
    public int countValidSelections(int[] nums) {

        int n = nums.length;
int ans =0;
        for(int i = 0 ; i <  n ; i++){
            if(nums[i] == 0){
                int left_sum = leftSum(nums , i);
                int right_sum = rightSum(nums,i);

                if(left_sum == right_sum) ans += 2;
                if((left_sum - right_sum == 1) || (right_sum - left_sum == 1)) ans+=1;
            }
        }
        return ans;
    }

    public int leftSum(int[] arr , int index){
        int sum = 0;
        for(int i = index ; i >= 0 ; i--){
            sum += arr[i];
        }

        return sum;
    }

    public int rightSum(int[] arr , int index){
        int sum = 0;
        for(int i =  index ; i < arr.length ; i++){
            sum += arr[i];
        }

        return sum;
    }
}