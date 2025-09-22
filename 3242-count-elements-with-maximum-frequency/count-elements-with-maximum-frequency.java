class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr= new int[101];
  
        for(int i = 0; i < nums.length ; i++){
            arr[nums[i]]++;
        }

        int maxFreq = 0;
        for(int  i  = 0 ;  i  < arr.length ; i++){
            if(arr[i] > maxFreq) maxFreq  = arr[i];
        }

        int ans = 0;
        for(int count : arr){
            if(count == maxFreq) ans += count;
        }

        return ans;
    }
}