class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for(int i =0 ; i <n ; i++){
        Arrays.fill(dist[i] , (int)Math.pow(10,9));
        }

        for(int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];
            int distance = edge[2];
            dist[src][dst] = distance;
            dist[dst][src] = distance;
        }
          for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < n ; j++){
               if(i == j) dist[i][j] = 0;
            }
        }
      
        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(dist[i]));
        }
        System.out.println("------------------");

        // Step 3: Floyd–Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if(i == k) continue;
                for (int j = 0; j < n; j++) {
                    if(j == k) continue;
                    if (dist[i][k]  != 1e9 && dist[k][j] != 1e9) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(dist[i]));
        }
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]); // if tie → larger index
            else return Integer.compare(a[0], b[0]); // smaller count first
        });

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) count++;
            }
            que.add(new int[]{count, i});
        }

        int[] ans = que.peek();
        return ans[1];
    }
}