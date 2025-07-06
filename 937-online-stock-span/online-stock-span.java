class StockSpanner {
    ArrayList<Integer> prices;
    ArrayList<Integer> spans;

    public StockSpanner() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        int i = prices.size() - 1;

        // Traverse backwards while prices[i] <= current price
        while (i >= 0 && prices.get(i) <= price) {
            span += spans.get(i);
            i -= spans.get(i);
        }

        prices.add(price);
        spans.add(span);

        return span;
    }
}
