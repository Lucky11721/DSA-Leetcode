class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int nBar = n+2;
        int mBar = m+2;

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int longestHbar = 1;
        int currBar = 1;
        for(int i = 0 ; i < hBars.length -1; i++ ){
            if(hBars[i+1] - hBars[i] == 1){
                currBar++;
            }
            else{
               
                currBar = 1;
            }
             longestHbar = Math.max(longestHbar , currBar);
        }
         longestHbar = Math.max(longestHbar , currBar);

         int longestVbar = 1;
        currBar = 1;
         for(int i = 0 ; i < vBars.length -1 ; i++ ){
            if(vBars[i+1] - vBars[i] == 1){
                currBar++;
            }
            else{
                currBar = 1;
            }
             longestVbar = Math.max(longestVbar , currBar);
        }
        longestVbar = Math.max(longestVbar , currBar);
        int side = Math.min(longestVbar , longestHbar) +1;
        return side*side;
    }
}