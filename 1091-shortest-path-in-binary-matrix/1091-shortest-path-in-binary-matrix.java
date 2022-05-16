class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        int temp[];
        int row, col, nrow, ncol, cost;
        int dir[][] = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, 
                                {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        while (!q.isEmpty()) {
            temp = q.remove();
            row = temp[0];
            col = temp[1];
            cost = temp[2];
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            if (row == n - 1 && col == n - 1)
                return cost;
            for (int k = 0; k < 8; ++k) {
                nrow = row + dir[k][0];
                ncol = col + dir[k][1];
                if (nrow < 0 || ncol < 0 || nrow >= n || ncol >= n || grid[nrow][ncol] == 1)
                    continue;
                q.add(new int[]{nrow, ncol, cost + 1});
            }  
        }
        return -1;
    }
}