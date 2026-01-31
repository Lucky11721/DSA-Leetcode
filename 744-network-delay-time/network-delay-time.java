class Solution {
    class Pair{
        int node;
        int time;
        Pair(int node , int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0 ;i <= n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph.get(u).add(new Pair(v ,t));


        }

        int[] dist = new int[n+1];

        Arrays.fill(dist , Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.time,b.time));

        minHeap.add(new Pair(k , 0));
        dist[k] = 0;

        while(minHeap.isEmpty() == false){
            Pair p  = minHeap.remove();
            int node = p.node;
            int time = p.time;


            for(Pair pair : graph.get(node) ){
                int totalTime = time + pair.time;

                if(totalTime < dist[pair.node]){
                    dist[pair.node] = totalTime;
                    minHeap.add(new Pair(pair.node , totalTime));
                }
            }
                   }
  int ans = -1;
        for(int i =1 ; i < n+1 ; i++){
            if(i != k){
                
                ans = Math.max(ans , dist[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}