class Solution {
    public String convertToTitle(int col) {
        String ans = "";

        while(col > 0){
            int rem = (col - 1) %26;
            ans = (char)('A'+ rem) +ans;
            col = (col - 1) / 26;
            System.out.println(rem + " " + ans + " " + col);
        }

        return ans;
    }
}