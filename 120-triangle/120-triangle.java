class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int c = 0; c < n; ++c)
            dp[n - 1][c] = triangle.get(n - 1).get(c);
        
        for (int r = n - 2; r >= 0; --r) {
            for (int c = 0; c < r + 1; ++c) {
                dp[r][c] = triangle.get(r).get(c) + Math.min(dp[r + 1][c], dp[r + 1][c + 1]);
            }
        }
        
        return dp[0][0];
    }
}