class Solution {
    int parent[];
    int size[];
    int[] ans;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size  =new int[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            parent[i] = i;
            size[i] = 1;
        }
        ans=  new int[2];

        for(int[] edge : edges){
            int a =  edge[0];
            int b = edge[1];

            union(a,b);

        }

        return ans;
    }

    public void union(int a , int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);
        if(leaderA != leaderB){
            if(size[leaderA] < size[leaderB]){
                parent[leaderA] =  leaderB;
                size[leaderB] += size[leaderA];
            }
            else{
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            }
        }
        else{
            ans[0] = a;
            ans[1] = b;
            return;
        }
    }

    public int findLeader(int a){
        if(parent[a] == a) return a;

        return parent[a] = findLeader(parent[a]);
    }
}