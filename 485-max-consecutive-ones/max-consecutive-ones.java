class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 1){
                count++;

                ans = Math.max(ans,count);
            }
            else{
                count = 0;
            }
        }
        return ans;
    }
}