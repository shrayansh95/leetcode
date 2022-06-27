class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1)
                    ++countFresh;
                else if (grid[i][j] == 2) 
                    q.add(new int[]{i, j});
            }
        }
        if (countFresh == 0)
            return 0;
        int ans = -1;
        int size;
        int temp[] = new int[2], nr, nc;
        int dir[] = new int[]{0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            ++ans;
            size = q.size();
            for (int j = 0; j < size; ++j) {
                temp = q.poll();
                for (int i = 0; i < 4; ++i) {
                    nr = temp[0] + dir[i];
                    nc = temp[1] + dir[i + 1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] != 1)
                        continue;
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                    --countFresh;
                }
            } 
        }
        return (countFresh == 0 ? ans : -1);
    }
}