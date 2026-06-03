class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int landSum = Integer.MAX_VALUE;

        for(int i = 0 ; i < landStartTime.length ; i++ ){
            landSum = Math.min(landSum , landStartTime[i] + landDuration[i]);
        }
        int landAns = Integer.MAX_VALUE;

        System.out.println(landSum);

        for(int i = 0 ; i < waterStartTime.length ; i++){
            int temp = landSum;
             if(waterStartTime[i] <= landSum){
               temp += waterDuration[i];
             }
             else{
                temp += (waterStartTime[i] - landSum) + waterDuration[i];
             }

             landAns = Math.min(temp , landAns);
        }

        System.out.println(landAns);


         int waterSum = Integer.MAX_VALUE;

        for(int i = 0 ; i < waterStartTime.length ; i++ ){
            waterSum= Math.min(waterSum , waterStartTime[i] + waterDuration[i]);
        }
        int waterAns = Integer.MAX_VALUE;

        System.out.println(waterSum);

        for(int i = 0 ; i < landStartTime.length ; i++){
            int temp = waterSum;
             if(landStartTime[i] <= waterSum){
               temp += landDuration[i];
             }
             else{
                temp += (landStartTime[i] - waterSum) + landDuration[i];
             }

             waterAns = Math.min(temp , waterAns);
        }

        System.out.println(waterAns);






        return Math.min(landAns , waterAns);       
    }
}