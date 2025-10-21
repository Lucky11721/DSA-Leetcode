class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            list.add(new ArrayList<>());
        }

      for(int[] edge : edges){
        int parent = edge[0];
        int child = edge[1];

        list.get(parent).add(child);
      }
      int[] indegree = new int[V];

      for(int i  = 0 ; i < V ; i++){
        for(int edge : list.get(i)){
            indegree[edge] += 1; 
        }
      }
      List<Integer> ans = new ArrayList<>();
      toposort_bfs(list, indegree , ans);

      if(ans.size() != V ) return false;

      return true;

      
    }

    public void toposort_bfs( List<List<Integer>> list , int[] indegree , List<Integer> ans){
        Queue<Integer> que = new LinkedList<>();

        for(int i =  0 ; i < indegree.length ; i++){
            if(indegree[i] == 0) que.add(i);
        }

        while(que.isEmpty() == false){
            int node = que.remove();
            ans.add(node);

            for(int child : list.get(node)){
                indegree[child] -= 1;

                if( indegree[child] == 0) que.add(child);
            }
        }


    }
}