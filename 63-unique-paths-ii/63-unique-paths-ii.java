class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int prev[] = new int[n], cur[] = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                } else if (i == 0 && j == 0)
                    cur[j] = 1;
                else {
                    int top = 0, left = 0;
                    if (i - 1 >= 0)
                        top = prev[j];
                    if (j - 1 >= 0)
                        left = cur[j - 1];
                    cur[j] = top + left;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
//     private int solve(int grid[][], int i, int j, int dp[][]) {
//         if (i < 0 || j < 0 || grid[i][j] == 1)
//             return 0;
//         if (i == 0 && j == 0)
//             return 1;
//         if (dp[i][j] != -1)
//             return dp[i][j];
        
//         return dp[i][j] = (top + left);
//     }
}