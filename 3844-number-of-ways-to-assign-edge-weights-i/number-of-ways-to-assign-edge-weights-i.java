class Solution {
    static final long MOD = 1_000_000_007L;
    public int assignEdgeWeights(int[][] edges) {

        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){

            int u = edge[0];

            int v = edge[1];

            map.putIfAbsent(u , new ArrayList<>());

            map.putIfAbsent(v , new ArrayList<>());

            map.get(u).add(v);

            map.get(v).add(u);
        }

        //System.out.println(map);

        int depth = getMaxDepth(map , 1,-1 );


        return (int)power(2,depth-1);
        
   }

   public int getMaxDepth(Map<Integer, List<Integer>> map , int root , int parent){
         
         int depth = 0;
List<Integer> neighbors = map.get(root);
         for(int edge : neighbors){
            if(edge == parent) continue;
  if (neighbors == null) {
            return 0;
        }
             depth = Math.max(depth, getMaxDepth(map, edge, root) + 1);
         }

         return depth;
   }

     

    private long power(long base , long exponent) {
        if (exponent == 0)
            return 1;

        long half = power(base, exponent / 2);

        long result = (half * half) % MOD;

        if (exponent % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }


}
