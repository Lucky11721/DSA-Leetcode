class Solution {
    int[] parent;

    public int findLeader(int a){
        if(parent[a]  == a) return a;

        return findLeader(parent[a]);
    }

    public void union(int a , int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);
        if(leaderA != leaderB){
            parent[leaderA] = leaderB;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){

                if(isConnected[i][j] == 1) union(i +1, j +1);
            }
        }

        int count = 0;
        for(int i = 0 ;i < n+1 ; i++){
            if(parent[i] == i) count++;
        }

        return count;
    }
}