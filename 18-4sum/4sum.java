class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);  // Optional but helps handle duplicates

        for(int i = 0; i < n - 3; i++){
            if (i > 0 && arr[i] == arr[i - 1]) continue;  // skip duplicate i
            for(int j = i + 1; j < n - 2; j++){
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;  // skip duplicate j
                for(int k = j + 1; k < n - 1; k++){
                    if (k > j + 1 && arr[k] == arr[k - 1]) continue;  // skip duplicate k
                    for(int l = k + 1; l < n; l++){
                        if (l > k + 1 && arr[l] == arr[l - 1]) continue;  // skip duplicate l
                        long sum = (long)arr[i] + arr[j] + arr[k] + arr[l];  // avoid integer overflow
                        if(sum == target){
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(arr[l]);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
