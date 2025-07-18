class Solution {
    public double myPow(double x, int n) {
        long N = n; // Convert to long to avoid overflow
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
