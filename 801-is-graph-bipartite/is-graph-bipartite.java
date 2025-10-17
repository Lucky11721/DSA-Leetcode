class Solution {
        int red = 0;
        int blue = 1;
    public boolean isBipartite(int[][] graph) {
        
        int n =   graph.length;

        int visited[] = new int[n];
        Arrays.fill(visited , -1);

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == -1){
                if(bfs(graph , i , visited) == false) return false;
            }
        }
        return true;

    }

    public boolean bfs(int[][] graph , int i , int[] visited){
        Queue<Integer> que = new LinkedList<>();

        que.add(i);
        que.add(red);

        while(que.isEmpty() == false){
            int parent = que.remove();
            for(int child : graph[parent]){
                if((visited[child] == -1)){
                   if(visited[parent] == red){
                     visited[child] = blue;
                   }
                   else{
                       visited[child] = red;
                   }
                   que.add(child);
                }
                else if(visited[child] != -1 &&  visited[child] == visited[parent]){
                    return false;
                }
            }
        }
        return true;
    }
}