class Solution {
    public int minSubarray(int[] arr, int p) {
        int n = arr.length;

        int total = 0;

        for(int ele : arr){
            total = (total + ele ) % p; 
        }

        int target = total;
        if(target == 0) return 0;

        int ans = n;

        Map<Integer , Integer> map = new HashMap<>();

        map.put(0 , -1);
        int curr = 0;
        for(int i  = 0 ; i < n ; i++){
         curr = (curr + arr[i]) %p;

         int find = (curr-target + p) %p;
         if(map.containsKey(find)){
            ans = Math.min(ans , i - map.get(find));
         }

         map.put(curr , i);
        }

        return ans == n ? -1 : ans;
    }
}
