class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;

        for(int i =1 ; i < n ; i++){
            arr[i] = arr[i] + arr[i-1];
        }

        HashMap<Integer , Integer> map = new HashMap<>();
       int count = 0;
        for(int num : arr){
            int sum = num;

            if(sum == k){
                count++;
            }

            int rem = sum - k;

            if(map.containsKey(rem)){
                count = count + map.get(rem);
            }
            if(map.containsKey(sum)){
                map.put(sum , map.get(sum) +1);
            }
            else{
                map.put(sum , 1);
            }
        }
        return count;
    }
}