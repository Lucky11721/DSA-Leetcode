class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        int i = 0; 
        int j = 0;

        while(j < n){
            if(sb.charAt(j) != ' '){
                j++;
            }
            else{
                reverse(sb , i , j-1);
                i = j+1;
                j=i;
            }
        }
        reverse(sb , i , j-1 );
        return sb.toString();
    }

    public void reverse(  StringBuilder str  , int i , int j){
        while(i <= j){
        char temp = str.charAt(i);
        str.setCharAt(i , str.charAt(j));
        str.setCharAt( j , temp);
        i++;
        j--;
        }
    }
}