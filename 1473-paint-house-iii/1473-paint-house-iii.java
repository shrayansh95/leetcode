class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int dp[][][] = new int[m][n + 1][target + 1];
        for (int it1[][] : dp)
            for (int it2[] : it1)
                Arrays.fill(it2, -1);
        int ans = solve(houses, cost, m, n, 0, 0, target, dp);
        return (ans == (int)1e9 ? -1 : ans);
    }
    private int solve(int houses[], int cost[][], int m, int n, int idx, int prevCol, int target, int dp[][][]) {
        if (idx == m || target < 0) 
            return target == 0 ? 0 : (int)1e9;
        if (dp[idx][prevCol][target] != -1)
            return dp[idx][prevCol][target];
        int curCol;
        if (houses[idx] != 0) {
            curCol = houses[idx];
            return dp[idx][prevCol][target] = solve(houses, cost, m, n, idx + 1, curCol, target - (curCol != prevCol ? 1 : 0), dp);
        }
        int ans = (int)1e9;
        int val = 0;
        for (curCol = 1; curCol <= n; ++curCol) {
            val = solve(houses, cost, m, n, idx + 1, curCol, target - (curCol != prevCol ? 1 : 0), dp);
            ans = Math.min(ans, cost[idx][curCol - 1] + val);
        }
        return dp[idx][prevCol][target] = ans;
    }
}