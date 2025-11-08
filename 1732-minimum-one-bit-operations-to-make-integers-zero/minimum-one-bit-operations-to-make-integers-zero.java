class Solution {
    public int minimumOneBitOperations(int n) {
        
        int[] F = new int[32];
        int sign = 1;
        int ans = 0;
        F[0] = 1;
        for(int i = 1;  i < 32 ; i++){
            F[i] = 2*(F[i-1]) +1;
        }
        for(int i = 31 ; i >= 0 ; i--){

            int ith_bit = (1<<i) & n;

            if(ith_bit==0) continue;

            if(sign >  0){
                ans += F[i];
            }
            else{
                ans -= F[i];
            }

            sign = sign * -1;
        }

        return ans;
    }
}