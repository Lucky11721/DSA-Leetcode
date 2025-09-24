class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n+1];
      int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                dfs(i , visited , isConnected);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int index , boolean[] visited , int[][] graph){

        visited[index] = true;

        for(int col = 0 ; col < graph[index].length ; col++){
            if(visited[col] == false && graph[index][col] == 1){
                dfs(col , visited , graph);
            }
        }
    }


    /*public void helper(boolean[] visited , int[][] graph , int index){

        Queue<Integer> que = new LinkedList<>();
        que.add(index);
        visited[index] = true;

        while(que.isEmpty() == false){
            int ele = que.remove();

            for(int i = 0 ; i < graph.length ; i++  ){
                if(visited[i] == false && graph[ele][i] == 1){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }*/
}