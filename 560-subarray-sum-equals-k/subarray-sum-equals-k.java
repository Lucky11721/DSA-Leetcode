class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;

        for(int i = 1 ; i < n ; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        int ans = 0;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i <  n ;i++){

            if(arr[i] == k) ans++;

            int rem =  arr[i] - k;

            if(map.containsKey(rem)){
                ans += map.get(rem);
            }

            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i])+1);
            }
            else{
                map.put(arr[i] , 1);
            }
        }


return ans;

    }
}