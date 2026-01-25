class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        

        int n = s.length();

        for(int i = 0 ; i< n ; i++){
            check(i , i , s , n); // for odd length palindrome
            check(i , i+1 , s , n) ; // for even length palindrome
        }

        return count;
    }

    public void check(int i , int j , String s , int n){

        while(i >= 0 && j < n  && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }
}