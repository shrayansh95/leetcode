class Solution {
    private final int MOD = (int)(1e9 + 7);
    private final int dir[] = new int[]{0, 1, 0, -1, 0};
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][] = new int[51][51][51];
        
        for (int it1[][] : dp) 
            for (int it2[] : it1)
                Arrays.fill(it2, -1);
        
        return solve(m, n, maxMove, startRow, startColumn, dp); 
    }
    
    private int solve(int n, int m, int maxMoves, int r, int c, int dp[][][]) {
        int isOut = outOfBounds(r, c, n, m);
        if (isOut == 1 || maxMoves == 0)
            return isOut;
        if (dp[maxMoves][r][c] != -1)
            return dp[maxMoves][r][c];
        int ans = 0, nr, nc;
        for (int i = 0; i < 4; ++i) {
            nr = r + dir[i];
            nc = c + dir[i + 1];
            ans = (ans + solve(n, m, maxMoves - 1, nr, nc, dp)) % MOD;
        }
        return dp[maxMoves][r][c] = ans;
    }
    
    private int outOfBounds(int r, int c, int n, int m) {
        if (r >= n || r < 0 || c >= m || c < 0)
            return 1;
        return 0;
    }
}