class Solution {
    public int minDeletionSize(String[] strs) {

        int ans =0;
        int n = strs.length;
        for(int j = 0 ; j < strs[0].length() ; j++){
            for(int i = 1 ; i < n ; i++){
                int prev = strs[i-1].charAt(j) - 'a';
                int curr = strs[i].charAt(j) - 'a' ; 
                
                if(prev > curr ){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}