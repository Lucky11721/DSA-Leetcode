class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;

        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        int curr_sum = 0;
        map.put(0,1);

        for(int i = 0;  i < n  ; i++){
        curr_sum += arr[i];


        int remaining = curr_sum - k;

        if(map.containsKey(remaining)){
            ans += map.get(remaining);
        }

        if(map.containsKey(curr_sum)){
            map.put(curr_sum , map.get(curr_sum) +1);
        }
        else{
            map.put(curr_sum , 1);
        }

        }
       return ans;
    }
}