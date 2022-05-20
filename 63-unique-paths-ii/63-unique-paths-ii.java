class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        return solve(obstacleGrid, m - 1, n - 1, dp);
    }
    private int solve(int grid[][], int i, int j, int dp[][]) {
        if (i < 0 || j < 0 || grid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int top = solve(grid, i - 1, j, dp);
        int left = solve(grid, i, j - 1, dp);
        return dp[i][j] = (top + left);
    }
}