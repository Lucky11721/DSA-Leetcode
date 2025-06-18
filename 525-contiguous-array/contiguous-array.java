class Solution {
    public int findMaxLength(int[] arr) {
        
        int n  = arr.length;

        int ans = 0;
        HashMap<Integer  , Integer> map = new HashMap<>();
        int sum = 0;
        for(int start = 0 ; start < n ; start++){

        if(arr[start] == 0){
            sum += -1;
        }
        else{
            sum += 1;
        }
        
        if(sum == 0){
            ans = start+1;
        }

        if(map.containsKey(sum)){
            ans = Math.max(ans , start - map.get(sum));
        }

        if(!map.containsKey(sum)){
            map.put(sum , start);
        }

        }

        return ans;
    }
}