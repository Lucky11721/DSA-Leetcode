class Solution {
    boolean ans = true;
    public boolean canFinish(int V, int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i  < V ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.length ; i++){
            int parent = graph[i][0];
            int child = graph[i][1];
            list.get(parent).add(child);
        }

        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];

        for(int i = 0; i < list.size() ; i++){
            if(visited[i] == false){
                dfs(list , visited , path ,i);
            }
        }
        
        return ans;

    }

    public void dfs(List<List<Integer>> list , boolean[] visited , boolean[] path , int node){
        visited[node] = true;
        path[node] = true;

        for(int child : list.get(node)){
            if(!visited[child]){
                dfs(list , visited , path , child);
            }
            else if(visited[child] == true && path[child] == true){
                 ans = false;
                 return;
            }

        }
        path[node] = false;
        
    }
}
