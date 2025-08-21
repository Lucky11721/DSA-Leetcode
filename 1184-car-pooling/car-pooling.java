class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        int[] change  = new int[1001];

        for(int[] trip : trips){
            int noOfpassenger = trip[0];
            int pick = trip[1];
            int drop = trip[2];

            change[pick] += noOfpassenger;
            change[drop] -= noOfpassenger;
        }
        int passenger = 0;
        for(int i = 0 ; i <  change.length  ; i++){
        passenger += change[i];

        if(passenger > capacity){
            return false;
        }
        }
        return true;
    }
}