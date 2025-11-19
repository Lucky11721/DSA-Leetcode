class Solution {
    List<Integer> topo = new ArrayList<>();
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            adj.get(prereq).add(course);

        }
        int[] in  = new int[V];
        for(int i = 0 ; i < V ; i++){
            for(int node : adj.get(i)){
                in[node] += 1;
            }
        }

        toposort_bfs(adj , in);
        System.out.println(Arrays.toString(in)  + "" + "size" + topo.size() + "  " + topo);
        if(topo.size() != V) return false;
        return true;
    }  

    public void toposort_bfs(List<List<Integer>> adj , int[] in){
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < in.length; i++){
            if(in[i] == 0) que.add(i);
        }

        while(que.isEmpty()== false){
            int vertex = que.remove();
            topo.add(vertex);
            for(int neigh : adj.get(vertex)){
                in[neigh] -= 1;
                if(in[neigh] == 0) que.add(neigh);
            }
        }
}
}
