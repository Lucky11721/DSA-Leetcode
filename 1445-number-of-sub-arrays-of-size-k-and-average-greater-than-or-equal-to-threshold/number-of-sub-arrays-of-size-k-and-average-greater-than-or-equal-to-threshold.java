class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
          int count = 0;
        int left = 0;
        int right = k-1;
       int sum = 0;
        for(int  i = 0 ;i <= right ; i++){
          sum += arr[i];
        }
        left++;
        right++;

        if(sum / k >= threshold) count++;
    

    while(right < n){
        sum = sum - arr[left - 1] + arr[right];
        if (sum / k >=  threshold)
            count++;
        left++;
        right++;
    }

    return count;
}}