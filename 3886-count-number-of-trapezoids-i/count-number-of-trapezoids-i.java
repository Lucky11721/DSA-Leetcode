class Solution {
    final int MOD = (int)Math.pow(10,9) +7;
    public int countTrapezoids(int[][] points) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] point : points){
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        long ans = 0;

        long prevHorizontalLines = 0;

        for(int count : map.values()){

            long horiZontalLines = (long)count * (count-1) /2;

            ans = (long)( ans + prevHorizontalLines * horiZontalLines)%MOD;
            prevHorizontalLines += horiZontalLines;
        }

        return (int)(ans % MOD); 
    }
}