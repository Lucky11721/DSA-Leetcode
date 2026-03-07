class Solution {
    public int minFlips(String s) {
        int n = s.length();

         s = s+s;

        StringBuilder start0 = new StringBuilder();
        StringBuilder start1 = new StringBuilder();

        for(int i = 0 ; i < 2*n ; i++){
             if(i %2 == 0){
                 start0.append('0');
                 start1.append('1');
             }
             else{
                 start0.append('1');
                start1.append('0');
             }

        }

        int i = 0 ;
        int j = 0;

        int ans = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;

        while(j < (2* n) ){

            char ch = s.charAt(j);

            if(ch != start0.charAt(j)){
                flip1++;
            }
            
            if(ch != start1.charAt(j)){
                flip2++;
            }

            if(j - i +1 > n){
                if(s.charAt(i) != start0.charAt(i)){
                     flip1--;
                }
                 if(s.charAt(i) != start1.charAt(i)){
                     flip2--;
                }

                i++;
            }

            if(j - i +1 == n){
              ans = Math.min(ans , Math.min(flip1 , flip2));
            }
            j++;
        }

        return ans;
    }
}