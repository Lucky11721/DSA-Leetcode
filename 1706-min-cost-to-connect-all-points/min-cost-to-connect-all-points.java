class Solution {
    class Triplet {
        int node;
        int parent;
        int weight;
        Triplet(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        boolean[] visited = new boolean[n];

        // Start from node 0
        minHeap.add(new Triplet(0, -1, 0));
        int min_cost = 0;

        while (!minHeap.isEmpty()) {
            Triplet top = minHeap.remove();
            int node = top.node;
            int weight = top.weight;

            // Skip if already visited
            if (visited[node]) continue;

            // Include this node in MST
            visited[node] = true;
            min_cost += weight;

            // Check all other nodes and add edges
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int x1 = points[node][0];
                    int y1 = points[node][1];
                    int x2 = points[i][0];
                    int y2 = points[i][1];
                    int manDist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                    minHeap.add(new Triplet(i, node, manDist));
                }
            }
        }

        return min_cost;
    }
}
