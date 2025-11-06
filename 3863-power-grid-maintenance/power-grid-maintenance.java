class Solution {
     int[] component;
    HashMap<Integer ,TreeSet<Integer>> map = new HashMap<>();
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        component = new int[c+1];
        for(int i  = 0 ; i  < c +1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge :connections ){
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        System.out.println(Arrays.toString(component));
        boolean[] visited = new boolean[c+1];
        for(int i = 1 ; i <= c ; i++){
            if(visited[i] == false){
                dfs(list , visited ,  i , i);
            }
        }
         System.out.println(Arrays.toString(component));
List<Integer> ans= new ArrayList<>();
         for(int[] query : queries){
            int type = query[0];
            int x = query[1];
            int cmp = component[x];
            if(type == 1){

                if(map.get(cmp).contains(x)){
                    ans.add(x);
                }
                else if(map.get(cmp).isEmpty() == false){
                    ans.add(map.get(cmp).first());
                }
                else{
                    ans.add(-1);
                }
            }
            else{
                map.get(cmp).remove(x);
            }
         }
         System.out.println(ans);
         int[] arr = new int[ans.size()];
         for(int i = 0 ;i < arr.length ; i++){
            arr[i] = ans.get(i);
         }
        return arr;
    }

    public void dfs( List<List<Integer>> list  , boolean[] visited , int cmpId , int node){
        visited[node] = true;
        component[node] = cmpId;

        if(map.containsKey(cmpId)){
            map.get(cmpId).add(node);
        }
        else{
            TreeSet<Integer> set = new TreeSet<>();
            set.add(cmpId);
            map.put(cmpId , set);
        }

        for(int neigh : list.get(node)){
            if(visited[neigh] == false){
                dfs(list , visited , cmpId , neigh);
            }
        }
    }
}