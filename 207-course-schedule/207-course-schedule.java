class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        List<Integer> adj[] = new List[numCourses];
        for (int i = 0; i < numCourses; ++i)
            adj[i] = new ArrayList<>();
        for (int it[] : prerequisites)
            adj[it[1]].add(it[0]);
        for (int i = 0; i < numCourses; ++i) {
            if (isCycle(i, adj, visited))
                return false;
        }
        return true;
    }
    private boolean isCycle(int i, List<Integer> adj[], int visited[]) {
        if (visited[i] == 1) return true;
        if (visited[i] == 0) {
            visited[i] = 1;
            for (int neighbour : adj[i]) 
                if (isCycle(neighbour, adj, visited))
                    return true;
        }
        visited[i] = 2;
        return false;
    }
}