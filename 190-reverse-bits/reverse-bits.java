class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        int ans = 0;

        for(int i = 0 ; i < 32 ; i++ ){
            ans = ans<<1;
            int setBit = n &1;
            ans = ans|setBit;
            n = n >> 1;
        }

        return ans;
    }
}