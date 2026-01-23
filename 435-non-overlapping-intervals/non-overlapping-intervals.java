class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         
         int ans  = 0 ;

         Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
         System.out.println(Arrays.deepToString(intervals));
         int prevEnd = intervals[0][1];
         for(int i  = 1 ; i< intervals.length ; i++){
               
                int currStart = intervals[i][0];
                int currEnd = intervals[i][1];

                if(currStart >= prevEnd){
                    prevEnd = currEnd;
                }
                else{
                    ans++;
                    prevEnd = Math.min(prevEnd , currEnd);
                }
            
         }

         return ans;
    }
}