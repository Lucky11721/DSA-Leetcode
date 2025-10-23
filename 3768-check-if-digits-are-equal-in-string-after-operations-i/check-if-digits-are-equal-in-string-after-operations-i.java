class Solution {
    public boolean hasSameDigits(String s) {
        
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > 2){
            StringBuilder curr = new StringBuilder();
            for(int i = 1 ; i < sb.length() ; i++){
               int a = sb.charAt(i) - '0';
               int b = sb.charAt(i - 1) - '0';


                int rem = (a+b) %10;

                curr.append(rem);
            }

            sb = curr;
        }

        if(sb.charAt(0) == sb.charAt(1)) return true;

        return false;
    }
}