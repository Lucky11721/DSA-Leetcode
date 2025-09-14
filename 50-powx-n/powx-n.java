class Solution {
    public double myPow(double x, int N) {
         long n = N;
        return helper(x , n);
    }

    public double helper(double x , long n){
        if(n == 0) return 1;
      if(n < 0){
        n = n *(-1);
        x = 1/x;
      }

        double half = helper(x , n/2);

        if(n %2 == 0){
            return half*half;
        }
        else{
            return half* half * x;
                    }
    }


}