class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;

        while(empty >= numExchange){
            int new_full_bottle = empty / numExchange;
            ans += new_full_bottle;
            empty = empty%numExchange + new_full_bottle;


        }
        return ans;
    }
}