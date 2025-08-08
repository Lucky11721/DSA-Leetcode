class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;

        int right = 0;
        for(int x = 0 ; x < n ; x++){
           right += arr[x];
        }

        int left = 1;
        int capacity = right;

        while(left <= right){
            int mid = left + (right - left)/2;
                int curr_days = 0;
                int sum  = 0 ;
                boolean flag = false;
            for(int i = 0 ; i <  n ; i++){
                 sum += arr[i];
                 if(arr[i] > mid){
                    flag = true;
                    break;
                 }
                 if(sum == mid){
                    curr_days += 1;
                    sum = 0;
                 }
                 else if(sum > mid){
                    curr_days += 1;
                    sum = arr[i];
                 }
            }
            
            if(sum > 0 ) curr_days += 1;

            if(curr_days <= days && flag != true){
                capacity = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }

        return capacity;


    }
}