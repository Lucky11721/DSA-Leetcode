class Solution {
    public int findCircleNum(int[][] graph) {
         int n = graph.length;
         int count = 0 ;
         boolean[] visited = new boolean[n];
         for(int i = 0; i < n ; i++){
            if(visited[i] == false){
                bfs(i ,  visited , graph);
                count++;
            }
         }
         return count;
    }

    public void bfs(int i , boolean[] visited , int[][] graph){
          visited[i] = true;
          Queue<Integer> que = new LinkedList<>();
          que.add(i);
     while(!que.isEmpty()){
            int front = que.remove();
            for(int j = 0; j < graph.length ; j++){
                if(graph[front][j] == 1 && visited[j] == false){
                    que.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}