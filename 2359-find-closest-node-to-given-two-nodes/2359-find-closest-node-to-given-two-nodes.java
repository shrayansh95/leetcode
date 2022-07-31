class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dist1[] = new int[n], dist2[] = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        bfs(node1, edges, dist1, n);
        bfs(node2, edges, dist2, n);
        int ans = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;
            if (min > Math.max(dist1[i], dist2[i])) {
                ans = i;
                min = Math.max(dist1[i], dist2[i]);
            }
        }
        return ans;
    }
    private void bfs(int node, int edges[], int dist[], int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        dist[node] = 0;
        boolean visited[] = new boolean[n];
        visited[node] = true;
        while (!q.isEmpty()) {
            var temp = q.poll();
            if (edges[temp] != -1 && !visited[edges[temp]]) {
                dist[edges[temp]] = dist[temp] + 1;
                visited[edges[temp]] = true;
                q.add(edges[temp]);
            }
        }
    }
}