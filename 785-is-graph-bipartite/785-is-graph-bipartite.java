class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        color[0] = 0;
        for (int i = 0; i < n; ++i) 
            if (!dfs(i, graph, color))
                return false;
        return true;
    }
    private boolean dfs(int i, int graph[][], int color[]) {
        for (int it : graph[i]) {
            if (color[it] == -1) {
                color[it] = color[i] ^ 1;
                if (!dfs(it, graph, color))
                    return false;
            } else if (color[it] == color[i]) 
                return false;
        }
        return true;
    }
}