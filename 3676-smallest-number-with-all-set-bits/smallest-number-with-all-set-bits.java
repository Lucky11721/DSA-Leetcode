class Solution {
    public int smallestNumber(int n) {
        
        int ans =1;

        while(ans < n){
            ans = 2*ans +1;
        }

        return ans;
    }
}