class Solution {
    public List<Boolean> checkIfPrerequisite(int V, int[][] prerequisites, int[][] queries) {
        int n = queries.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        int[] in = new int[V];
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            in[v] += 1;
        } 

        // print adj list
        System.out.println(adj + "indegree : " + Arrays.toString(in));
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0 ; i < V;  i++){
            if(in[i] == 0) que.add(i);
        }
        if(que.size() == in.length){
            List<Boolean> list = new ArrayList<>();
            for(int i = 0 ; i < V ; i++){
                list.add(false);
            }
            return list;
        }
        List<Integer> topo = new ArrayList<>();
        HashMap<Integer ,Set<Integer>> map = new HashMap<>();

        while(que.isEmpty() == false){
            int vertex = que.remove();
            topo.add(vertex);
            for(int neigh : adj.get(vertex)){
                map.putIfAbsent(neigh, new HashSet<>());
                map.putIfAbsent(vertex, new HashSet<>());
                 map.get(neigh).add(vertex);
                for(int ele : map.get(vertex)){
                     map.get(neigh).add(ele);
                }
                in[neigh]  -= 1;
                if(in[neigh] == 0) que.add(neigh);
            }
        }
       List<Boolean> ans = new ArrayList<>();

       for(int[] query : queries){
            int c1 = query[0];
            int c2 = query[1];
            if(map.get(c2).contains(c1)){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
       }

       return ans;
    }
}