class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int drank  = numBottles;
        int exchange = numBottles;

        while(exchange >= numExchange){

            exchange = exchange - numExchange;
                drank += 1;
                exchange++;
          numExchange++;
        }
        return drank ;
        
    }
}