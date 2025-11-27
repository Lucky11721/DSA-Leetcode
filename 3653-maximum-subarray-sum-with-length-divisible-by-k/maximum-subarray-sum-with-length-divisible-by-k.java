class Solution {
    public long maxSubarraySum(int[] arr, int k) {
        int n = arr.length;

    long[] prefixSum = new long[n];
    prefixSum[0] = arr[0];
    for(int i = 1 ; i < n ; i++){
        prefixSum[i] = arr[i] + prefixSum[i-1];
    }
    System.out.println(Arrays.toString(prefixSum));

    long ans = Long.MIN_VALUE;
    for(int start = 0 ; start < k ; start++){
        long currSum = 0;
        int i = start;
        while(i < n && i +k -1 < n){
              int j = i +k -1;
              long subSum = prefixSum[j] - ((i-1 >= 0) ? prefixSum[i-1] : 0);
              currSum = Math.max(subSum , subSum + currSum);
              ans = Math.max(currSum , ans);

              i  += k;
        }
    }
    return ans;
    }
}