class Solution {
    public int integerBreak(int n) {
         if(n == 2) return 1;
         if(n == 3) return 2;
         int rem = n % 3;
         int divide = n /3;
        System.out.println(divide);
        System.out.println(rem);
         int ans = 1;
         if(rem == 0){
            return (int)Math.pow(3 , divide);
         }

         if(rem == 1){
            return (int)Math.pow(3 , divide - 1) *4;
         }
         else if(rem == 2){
            return (int)Math.pow(3 , divide) *2;
         }

         return -1;
    }
}