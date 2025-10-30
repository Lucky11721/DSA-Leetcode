class Solution {
    class Pair{
        int node;
        int distance;

        Pair(int node , int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int source =edge[0];
            int target = edge[1];
            int distance = edge[2];

            adj.get(source).add(new Pair(target , distance));
        }
        for(int i = 0 ; i < adj.size() ; i++){
            for(Pair p : adj.get(i)){
                System.out.println(p.node + " " + p.distance);
            }
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance , Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.distance , b.distance));
        minHeap.add(new Pair(k , 0));

        while(!minHeap.isEmpty()){
            Pair p = minHeap.remove();
            int src = p.node;
            int dist = p.distance;
            if(dist > distance[src]) continue;

            for(Pair neighbour : adj.get(src)){
                int child = neighbour.node;
                int child_distance = neighbour.distance;

                int total_distance = dist + child_distance;
                if(total_distance < distance[child]){
                    distance[child] = total_distance;
                    minHeap.add(new Pair(child , total_distance));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        int ans = -500;
        for(int i =1 ; i < n+1 ; i++){
            if(i != k){
                
                ans = Math.max(ans , distance[i]);
            }
        }


        if(ans == Integer.MAX_VALUE) return -1;


        return ans;


    }
}