class Solution {
    public boolean hasAlternatingBits(int n) {
        String check = "";

        while(n > 0){
            int bit = (n & 1);
            check = check + bit;
            n = n >>1;
        }

        System.out.println(check);
        for(int i = 1 ; i < check.length() ; i++){
            if(check.charAt(i) == check.charAt(i-1)){
                return false;
            }
        }

        return true;
    }
}