class Solution {
    int dir[] = new int[]{0, 1, 0, -1, 0};
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        for (int i = 0; i < n; ++i) 
            for (int j = 0; j < m; ++j) 
                ans = Math.max(ans, dfs(matrix, i, j, n, m, dp));
        return ans;
    }
    private int dfs(int matrix[][], int r, int c, int n, int m, int dp[][]) {
        if (dp[r][c] != -1)
            return dp[r][c];
        int ans = 1, nr, nc;
        for (int i = 0; i < 4; ++i) {
            nr = r + dir[i];
            nc = c + dir[i + 1];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || matrix[nr][nc] <= matrix[r][c])
                continue;
            ans = Math.max(ans, dfs(matrix, nr, nc, n, m, dp) + 1);
        }
        return dp[r][c] = ans;
    }
}