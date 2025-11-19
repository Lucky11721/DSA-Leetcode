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
        } 
        List<Boolean> ans  = new ArrayList<>();
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            boolean[] visited = new boolean[V];
            boolean check  = dfs(adj , start , end , visited);
            ans.add(check);
        }

        return ans;
    }

    public boolean dfs( List<List<Integer>> adj  , int start , int end , boolean[] visited){
        visited[start] = true;

        for(int neigh : adj.get(start)){
            if(neigh == end) return true;
            if(visited[neigh] == false){
                if( dfs(adj , neigh , end , visited)){
                    return true;
                }
            }
        }

        return false;
    }
}