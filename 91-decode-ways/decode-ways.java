class Solution {
    public int numDecodings(String s) {
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length +1];
        Arrays.fill(dp , -1);
        return helper(ch, 0 , dp);
    }

    public int helper(char[] ch, int index ,int[] dp) {
        if (index == ch.length)
            return 1;

        if (ch[index] == '0')
            return 0;
       if(dp[index] != -1) return dp[index];
        int take1 = helper(ch, index + 1 , dp);
        int take2 = 0;
        if (index + 1 < ch.length) {
            if (ch[index] == '1' || ch[index] == '2' && ch[index + 1] <= '6') {
                take2 = helper(ch, index + 2 , dp);
            }

        }

        return dp[index] = take1 + take2;
    }
}