class Fancy {

    List<Long> list;

long add = 0;
    long mul = 1;
    long MOD = (long)1e9+7;

    private long power(long x , long pow){

        if(pow == 0) return 1;


        long half = power(x, pow/2);

        long result = (half*half)%MOD;

        if(pow%2 == 1){
            return (result*x) % MOD;
        }

        return result;
    }

    public Fancy() {
        list = new ArrayList<>();
    }
    
    public void append(int val) {
        long x = (((val - add) %MOD + MOD) * (power(mul , MOD-2)%MOD) %MOD);
        list.add(x);
               
    }
    
    public void addAll(int inc) {

        add = (add+ inc) %MOD;
        
    }
    
    public void multAll(int m) {
        mul = (mul*m)%MOD;
        add = (add*m)%MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size()) return -1;

        return (int)((list.get(idx) *mul + add) %MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */