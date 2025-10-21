class Solution {
    public int[] findOrder(int n, int[][] pre) {
        
        int m = pre.length;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : pre){
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
        }

        int[] indegree = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }
         List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ;i < n ; i++){
            if(indegree[i] == 0) que.add(i);
        }

        while(que.isEmpty() == false){
            int node = que.remove();
            list.add(node);

            for(int child : graph.get(node)){
                indegree[child]--;
                if(indegree[child] == 0) que.add(child);
            }
        }

        if(list.size() != n) return new int[0];
        Collections.reverse(list);

        int[] ans = new int[list.size()];

        for(int i = 0 ; i < n ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}