class Solution {
    public int longestBalanced(String s) {
       
        int ans = 1;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            int[] freq = new int[26];
            for(int j = i ; j < n ; j++){
                int index = s.charAt(j) - 'a';
                freq[index]++;

                if(checkBalanced(freq)){
                    ans = Math.max(ans , j - i+1);
                }
            }
        }

        return ans;
    }

    public boolean checkBalanced(int[] freq){
        int common = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] == 0) continue;
            if(common == 0){
                common = freq[i];
            }
            else if(common != freq[i]) return false;
        }

        return true;
    }
}