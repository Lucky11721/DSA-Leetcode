class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

      for(int i = 0 ; i <n;  i++){
        for(int j = 0; j < graph[i].length ; j++){
            list.get(graph[i][j]).add(i);
        }
      }
      int[] indegree = new int[n];

      for(List<Integer> edge : list){
        for(int i = 0 ; i < edge.size()  ; i++){
            indegree[edge.get(i)]++;
        }
      }
      System.out.println(Arrays.toString(indegree));
        System.out.println(list);
        List<Integer> ans = new ArrayList<>();
        topology_bfs(list , indegree , ans);

        Collections.sort(ans);


        return ans;
        
    }
    public void topology_bfs(List<List<Integer>> graph , int[] indegree , List<Integer> list){

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0) que.add(i);
        }

        while(que.isEmpty() == false){
            int node = que.remove();
            list.add(node);

            for(int i = 0 ; i < graph.get(node).size() ; i++){
                int neighbour = graph.get(node).get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    que.add(neighbour);
                }
            }
        }


    } 
}