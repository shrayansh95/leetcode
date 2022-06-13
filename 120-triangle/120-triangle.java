class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        return solve(0, 0, triangle, n, dp);
    }
    private int solve(int r, int c, List<List<Integer>> triangle, int n, int dp[][]) {
        if (r == n)
            return 0;
        if (dp[r][c] != -1)
            return dp[r][c];
        return dp[r][c] = triangle.get(r).get(c) + Math.min(solve(r + 1, c, triangle, n, dp), solve(r + 1, c + 1, triangle, n, dp));
    }
}