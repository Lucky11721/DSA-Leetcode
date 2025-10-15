class Solution {
    public int maxIncreasingSubarrays(List<Integer> arr) {
        int n = arr.size();

        int ans = Integer.MIN_VALUE;
        int prev_length = 0;
        int curr_length  =1;

        for(int i =1 ; i < n; i++){
            if(arr.get(i) > arr.get(i-1)){
                curr_length++;
                if((curr_length%2) == 0){
                    ans = Math.max(ans , curr_length/2);
                }
            }
            else{
                if(prev_length > 0 && curr_length > 1){
                    int curr_k = Math.min(prev_length , curr_length);
                    ans = Math.max(ans , curr_k);
                }

                prev_length = curr_length;
                curr_length =1;
            }
        }
        System.out.println(prev_length + " " + curr_length + " " + ans);
        if(ans != Integer.MIN_VALUE && ans > Math.min(curr_length , prev_length)) return ans;

        return Math.min(curr_length , prev_length);
    }
}