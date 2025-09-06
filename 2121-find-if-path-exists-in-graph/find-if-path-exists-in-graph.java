class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();

        for(int  i = 0 ; i  < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean visited[] = new boolean[n];

        helper(list , source , visited);

        return visited[destination];

    }

    public void helper(List<List<Integer>> list, int source , boolean[] visited){

        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = true;

        while(que.isEmpty() == false){
            int ele = que.remove();
            
            for(int value : list.get(ele)){
                if(visited[value] == false){
                    que.add(value);
                    visited[value] = true;
                }
            }
        }
    }
}