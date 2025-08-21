class Solution {
    public boolean carPooling(int[][] arr, int capacity) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));

        for(int i = 0 ; i < n ; i++){
            int curr_passenger = arr[i][0];
            for(int j  = 0 ; j <  i ; j++){
                if(arr[j][2] > arr[i][1]){
                    curr_passenger += arr[j][0]; 
                }
            }
            if(curr_passenger > capacity){
                return false;
            }
        }
        return true;
    }
}