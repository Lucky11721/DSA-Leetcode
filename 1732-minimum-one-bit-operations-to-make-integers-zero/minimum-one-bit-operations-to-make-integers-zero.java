class Solution {
    public int minimumOneBitOperations(int n) {
        int[] F = new int[32];
        int sign = 1; // ✅ should start positive
        int ans = 0;

        // Precompute F[i]
        F[0] = 1;
        for (int i = 1; i < 32; i++) {
            F[i] = 2 * F[i - 1] + 1;
        }

        // Iterate from MSB to LSB
        for (int i = 30; i >= 0; i--) {
            int ith_bit = (1 << i) & n; // ✅ correct bit mask
            if (ith_bit == 0) continue;

            if (sign > 0) {
                ans += F[i];
            } else {
                ans -= F[i];
            }

            sign *= -1; // alternate the sign
        }

        return Math.abs(ans); // ✅ ensure non-negative
    }
}
