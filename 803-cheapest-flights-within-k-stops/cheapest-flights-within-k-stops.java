import java.util.*;

class Solution {
    class Pair {
        int flight, cost;
        Pair(int flight, int cost) {
            this.flight = flight;
            this.cost = cost;
        }
    }

    class Triplet {
        int flight, cost, stops;
        Triplet(int flight, int cost, int stops) {
            this.flight = flight;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] route : flights) {
            adj.get(route[0]).add(new Pair(route[1], route[2]));
        }

        // cost[] = min cost to reach a node
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        // stopsAt[] = min stops used to reach a node
        int[] stopsAt = new int[n];
        Arrays.fill(stopsAt, Integer.MAX_VALUE);
        stopsAt[src] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Triplet(src, 0, 0));

        while (!pq.isEmpty()) {
            Triplet curr = pq.poll();

            int node = curr.flight;
            int currCost = curr.cost;
            int currStops = curr.stops;

            if (node == dst) return currCost;
            if (currStops > k) continue;

            for (Pair next : adj.get(node)) {
                int newCost = currCost + next.cost;
                int nextNode = next.flight;

                // Only push if better in cost or reached with fewer stops
                if (newCost < cost[nextNode] || currStops + 1 < stopsAt[nextNode]) {
                    cost[nextNode] = newCost;
                    stopsAt[nextNode] = currStops + 1;
                    pq.add(new Triplet(nextNode, newCost, currStops + 1));
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
