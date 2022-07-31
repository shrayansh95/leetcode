class Solution {
    public int longestCycle(int[] edges) {
        int max[] = new int[]{-1};
        int n = edges.length;
        boolean visited[] = new boolean[n];
        int length[] = new int[n];
        Arrays.fill(length, -1);
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, edges, length, 0, max, visited);
            }
        }
        return max[0];
    }
    
    private void dfs(int i, int edges[], int distFromStart[],
                    int curLen, int max[], boolean visited[]) {
        if (!visited[i]) {
            visited[i] = true;
            distFromStart[i] = curLen;
            if (edges[i] != -1)
                dfs(edges[i], edges, distFromStart, curLen + 1, 
                    max, visited);
            distFromStart[i] = -1;
        } else {
            if (distFromStart[i] != -1) 
                max[0] = Math.max(curLen - distFromStart[i], max[0]);
        }
    }
}