class Solution {

   class Pair implements Comparable<Pair> {
    int node;
    double prob;

    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }

    @Override
    public int compareTo(Pair other) {
        return Double.compare(this.prob, other.prob); 
    }
}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double probability = succProb[i];
            adj.get(a).add(new Pair(b, probability));
            adj.get(b).add(new Pair(a, probability));
        }
        for (int i = 0; i < n; i++) {
            for (Pair p : adj.get(i)) {
                System.out.println(p.node + " " + p.prob);
            }
            System.out.println();
        }
        double[] max_probability = new double[n];
        Arrays.fill(max_probability, Integer.MIN_VALUE);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(new Pair(start_node, 1));
        max_probability[start_node] = 1;

        while (maxHeap.isEmpty() == false) {
            Pair top = maxHeap.remove();
            int parent = top.node;
            double prob = top.prob;
            if (prob > max_probability[parent])
                continue;

            for (Pair neighbour : adj.get(parent)) {
                int child = neighbour.node;
                double prb = neighbour.prob;
                double max_prob = prb * prob;
                if (max_prob > max_probability[child]) {
                    max_probability[child] = max_prob;
                    maxHeap.add(new Pair(child, max_prob));
                }
            }
        }

        if (max_probability[end_node] == Integer.MIN_VALUE)
            return 0;

        return max_probability[end_node];
    }
}