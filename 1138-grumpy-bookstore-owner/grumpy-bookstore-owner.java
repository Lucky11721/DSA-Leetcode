class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
       int ans= 0;
        for(int  a =  0 ; a <  n ; a++){
            if(grumpy[a] == 0){
                ans += customers[a];
            }
        }

        int i  = 0 ;
        int j = minutes -1;
    
       int maxunsat = 0;
       int unsat = 0;
        while( j < n){
           
            for(int a = i ; a <= j ; a++){
                if(a == n) break;
                if(grumpy[a] == 1 ){
                   unsat += customers[a];
                }

              
            }
              maxunsat = Math.max(unsat , maxunsat);

                i++;
                j++;
                 unsat = 0;
        }

        return ans + maxunsat;
    }
}