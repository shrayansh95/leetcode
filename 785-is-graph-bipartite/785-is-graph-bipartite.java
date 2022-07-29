class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; ++i) 
            if (color[i] == -1 && !bfs(i, graph, color)) 
                return false;
        return true;
    }
    // private boolean dfs(int i, int graph[][], int color[]) {
    //     for (int it : graph[i]) {
    //         if (color[it] == -1) {
    //             color[it] = color[i] ^ 1;
    //             if (!dfs(it, graph, color))
    //                 return false;
    //         } else if (color[it] == color[i]) 
    //             return false;
    //     }
    //     return true;
    // }
    private boolean bfs(int i, int graph[][], int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int it : graph[temp]) {
                if (color[it] == -1) {
                    color[it] = color[temp] ^ 1;
                    q.add(it);
                } else if (color[it] == color[temp])
                    return false;
            }
        }
        return true;
    }
}