class Solution {
    class Pair{
        String divisor;
        double val;

        Pair(String divisor , double val){
            this.divisor = divisor;
            this.val =  val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        // step 1 build map for division in both direction;
        HashMap<String ,List<Pair>> map = new HashMap<>();

        for( int i = 0 ; i < equations.size() ; i++ ){

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            map.putIfAbsent(u , new ArrayList<>());
            map.putIfAbsent(v , new ArrayList<>());

            map.get(u).add(new Pair(v , value));
            map.get(v).add(new Pair(u , 1.0/value));
        }
        
        // step 2 apply dfs
        double[] result = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            String src = query.get(0);
            String dst = query.get(1);

            double[] ans = new double[1];
            ans[0] = -1.0;
            if(map.containsKey(src)){  Set<String> set = new HashSet<>();
            dfs(map , src , dst ,  set , 1.0 , ans);
            }

            result[i] = ans[0];
            i++;
        }
        return result;
        
    }

    public void dfs(HashMap<String ,List<Pair>> map ,  String src , 
    String dst , Set<String> set, double product  , double[] ans ){
        if(set.contains(src)) return;

        set.add(src);

        if(src.equals(dst)){
            ans[0] = product;
            return;
        }

        for(Pair p : map.get(src)){
            String v= p.divisor;
            double val = p.val;
            dfs(map , v , dst , set , product * val , ans);
        }
    }
}