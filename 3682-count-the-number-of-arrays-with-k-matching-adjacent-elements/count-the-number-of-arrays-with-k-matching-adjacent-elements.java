class Solution {
    long mod = 1_000_000_007L;

    public int countGoodArrays(int n, int m, int k) {
        long total_ways = (m * power(m - 1, n - k - 1)) % mod;
        long possible_pair = ncr(n-1, k);
        return (int)((total_ways * possible_pair) % mod);
    }

    public long power(long a, long b){
        if(b == 0) return 1;
        long half = power(a, b / 2) % mod;
        long result = (half * half) % mod;
        if(b % 2 == 1) result = (result * a) % mod;
        return result;
    }

    public long ncr(int n, int k){
        if(k > n) return 0;
        long a = fact(n);
        long b = (fact(k) * fact(n - k)) % mod;
        return (a * power(b, mod - 2)) % mod;
    }

    public long fact(int n){
        long result = 1;
        for(int i = 2; i <= n; i++){
            result = (result * i) % mod;
        }
        return result;
    }
}
