class Solution {
    public int countBinarySubstrings(String s) {

        int n = s.length();
        int ans =0;

        int currCount = 1;
        int prevCount = 0;

        for(int i =1 ; i < n ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currCount++;
            }
            else{
                ans = ans + Math.min(currCount , prevCount);
                prevCount = currCount;
                currCount = 1;
            }
        }


        return ans + Math.min(prevCount , currCount);
    }
}
