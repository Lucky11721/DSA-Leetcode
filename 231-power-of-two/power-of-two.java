class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n == 1) return true;

       double num = 1;
       int power = 0;
       while(num <  n){
        num = (double)Math.pow(2 , power);
        power++;
       }

       if(num == n) return true;

       return false;
    }
}