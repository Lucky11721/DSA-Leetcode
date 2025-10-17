class Solution {
    int red = 0;
    int blue = 1;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);  // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                // start DFS with red color
                if (!dfs(graph, i, red, visited)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int color, int[] visited) {
        visited[node] = color;

        for (int neigh : graph[node]) {
            if (visited[neigh] == -1) {
                // give opposite color
                if (!dfs(graph, neigh, 1 - color, visited)) return false;
            } else if (visited[neigh] == color) {
                // same color neighbor → not bipartite
                return false;
            }
        }
        return true;
    }
}
