class Solution {
    public int minCost(String colors, int[] time) {
        char[] color = colors.toCharArray();
        int n = color.length;

        int min_time = 0;
        int maxTime = time[0];
        for(int i = 1 ; i < n ; i++){
            int pre = color[i-1];
            int curr = color[i];
            
            if(pre == curr){
                  min_time += Math.min(maxTime, time[i]);
                  maxTime = Math.max(maxTime , time[i]);
            }
            else{
                maxTime = time[i];
            }
           
        }

        return min_time;
    }
}