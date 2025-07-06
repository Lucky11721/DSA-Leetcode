class StockSpanner {
    ArrayList<Integer> prices;


    public StockSpanner() {
        prices = new ArrayList<>();
 
    }

    public int next(int price) {
         int count = 1;

        for(int  i = prices.size() -1; i >= 0 ; i--){
            if(price >= prices.get(i)){
                count++;
            }
            else{
                break;
            }

        }
        prices.add(price);
     

        return count;
    }
}
