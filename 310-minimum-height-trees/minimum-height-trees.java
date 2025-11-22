class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
     if (n == 1) return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i <  n ; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u] += 1;
            indegree[v] +=1;
        }

        Queue<Integer> que  = new LinkedList<>();

        for(int i  = 0 ; i < n ; i++){
            if(indegree[i] == 1) que.add(i);
        }

        while( n > 2){
            int size = que.size();

            n = n- size;

            while(size > 0){
                int node = que.remove();   
                size--; 
                for(int neigh : adj.get(node)){
                    indegree[neigh] -=1;
                    if(indegree[neigh] == 1) que.add(neigh);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(que.size() >  0){
            ans.add(que.remove());
        }

        return ans;
}
}