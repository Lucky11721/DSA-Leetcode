class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        helper(0 , visited  , rooms);

        for(int i = 0; i < visited.length ; i++){
            if(visited[i] == false) return false;
        }
        return true;
    }

    public void helper(int index ,  boolean[] visited , List<List<Integer>> rooms){

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[index] = true;

        while(que.isEmpty() == false){
            int ele = que.remove();

           for (int key : rooms.get(ele)) {
                if (!visited[key]) {
                    visited[key] = true;
                    que.add(key);
                }
            }
        }
    }
}