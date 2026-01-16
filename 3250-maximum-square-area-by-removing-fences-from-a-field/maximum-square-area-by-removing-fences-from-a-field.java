class Solution {

   private static final int MOD = 1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hFence= new ArrayList<>();

        hFence.add(1);
        hFence.add(m);

        List<Integer> vFence= new ArrayList<>();
        vFence.add(1);
        vFence.add(n);

        for(int i = 0 ; i < hFences.length; i++){
            hFence.add(hFences[i]);
        }

         for(int i = 0 ; i < vFences.length; i++){
            vFence.add(vFences[i]);
        }

        HashSet<Integer> hSet = new HashSet<>();

        HashSet<Integer> vSet = new HashSet<>();

        for(int i = 0 ; i < hFence.size() ; i++){
            for(int j = i+1 ; j < hFence.size() ; j++){
                int width = Math.abs( hFence.get(j) - hFence.get(i));
                hSet.add(width);
            }
        }

 for(int i = 0 ; i < vFence.size() ; i++){
            for(int j = i+1 ; j < vFence.size() ; j++){
                int width = Math.abs(vFence.get(j) - vFence.get(i));
                vSet.add(width);
            }
        }

      
        long maxSide = 0;
        for(int width : hSet){
            if(vSet.contains(width)){
              maxSide = Math.max(width , maxSide);
            }
        }

        if(maxSide == 0) return -1;

        long area = maxSide * maxSide;
        return (int)(area % MOD);


    }
}