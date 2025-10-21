class Solution {
    public int maxFrequency(int[] arr, int k, int numOperations) {
        
        int n = arr.length;

        int max_ele = -1;

        for(int i  = 0; i < n  ;i++){
            max_ele = Math.max(max_ele , arr[i]);
        }
        int[] freq = new int[max_ele + k+1];
        int upper_limit = max_ele +k;

        for(int i = 0 ; i < arr.length ; i++){
            freq[arr[i]] += 1;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int result = 0;

        for(int target = 0 ; target <= upper_limit;  target++){
            if(freq[target] == 0) continue;

              int leftNum = Math.max(0, target - k);
            int rightNum = Math.min(max_ele, target + k);

            int totalCount = freq[rightNum] - (leftNum > 0 ? freq[leftNum - 1] : 0);
            int targetCount = freq[target] - (target > 0 ? freq[target - 1] : 0);

            int needConversion = totalCount - targetCount;
            int maxPossibleFreq = targetCount + Math.min(needConversion, numOperations);

            result = Math.max(result, maxPossibleFreq);
        }

        return result;

    }
}