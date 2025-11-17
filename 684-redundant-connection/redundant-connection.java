class Solution {
    int[] parent;
    int[] ans;
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parent = new  int[n+1];
        ans = new int[2];
        for(int i = 0 ; i < n+1 ; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            union(u , v);
        }
        return ans;
    }

    public void union(int a , int b){
        int leaderA = find(a);
        int leaderB = find(b);
        if(leaderA != leaderB ){
            parent[leaderA] = leaderB;
        }
        else{
            ans[0] =a;
            ans[1] = b;
            return;
        }
    }

    public int find(int a){
        if(parent[a] == a) return a;

        return find(parent[a]);
    }
}