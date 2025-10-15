class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> arr, int k) {
        int n  = arr.size();
        int prev_length = 0;
        int curr_length  =1;
        for(int i = 1 ; i <  n ; i++){
            if(arr.get(i) > arr.get(i-1)){
                curr_length++;
                if(curr_length/2 >= k){
                    return true;
                }
            }
            else{
                if(prev_length >= k && curr_length >= k){
                    return true;
                }
                else{
                    prev_length = curr_length;
                    curr_length = 1;
                }
            }
        }

      if(prev_length >= k && curr_length >= k){
                    return true;
                }
        return false;
    }
}