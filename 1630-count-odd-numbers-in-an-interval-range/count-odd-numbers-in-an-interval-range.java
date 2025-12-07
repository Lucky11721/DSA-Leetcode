class Solution {
    public int countOdds(int low, int high) {
         int ans = 0;

         int diff = high - low;
         if(low % 2 != 0 ) ans +=1;
         if(high % 2 != 0) ans += 1;
         if(low % 2 != 0 && high % 2 != 0){
                ans += (diff -2) /2;
         }
         else{
            ans += diff /2;
         }


         return ans;
    }
}