class Solution {
    public int longestSubarray(int[] arr) {
        int i = 0;
        int j = 0 ;
        int n = arr.length;

        int ans = 0;
        int zero  = 0;
        boolean flag = true;
        for(int z = 0 ; z < n ; z++){
             if(arr[z] == 0){
                flag = false;
                break;
             }
        }

        while( j < n){

            if(arr[j] == 0){
                zero++;
            }

            while( zero > 1){
                if(arr[i] == 0){
                    zero--;
                }
                i++;
            }
          
            ans = Math.max(ans , j - i + zero -1); j++;
        }

        if(flag == true) return n - 1;

        return ans;
    }
}