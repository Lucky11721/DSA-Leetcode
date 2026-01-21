class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();

        // Step 1: extract exactly 32 bits
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            sb.append(bit);      // appending 0 or 1
            n = n >>> 1;         // logical right shift
        }

        // Step 2: reverse bits
        sb.reverse();

        System.out.println(sb);
        // Step 3: convert binary string to integer
        int ans = 0;

       int power = 0;

       for(int i = 0 ;i < 32 ; i++){
        ans += (sb.charAt(i) - '0') * Math.pow(2,i);
       }

        return ans;
    }
}
