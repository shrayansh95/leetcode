class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int dist[][] = new int[n][m];
        for (int it[] : dist)
            Arrays.fill(it, (int)1e9);
        dist[0][0] = 0;
        int dir[] = new int[]{0, -1, 0, 1, 0};
        PriorityQueue<Node> pq = new PriorityQueue<>(new SortByDist());
        pq.add(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int d = node.d, r = node.r, c = node.c;
            if (r == n - 1 && c == m - 1)
                return d;
            for (int i = 0; i < 4; ++i) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && d + grid[nr][nc] < dist[nr][nc]) {
                    dist[nr][nc] = d + grid[nr][nc];
                    pq.add(new Node(dist[nr][nc], nr, nc));
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}

class Node {
    int d, r, c;
    Node(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

class SortByDist implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return a.d - b.d;
    }
}