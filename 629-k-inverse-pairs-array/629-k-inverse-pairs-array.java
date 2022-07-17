class Solution {
    // private final int MOD = (int)(1e9 + 7);
    public int kInversePairs(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        dp[0][0] = 1;
        int MOD = 1000000007;
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if(j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                    dp[i][j] = (dp[i][j] + MOD) % MOD;
                }
            }
        }
        return dp[n][k];
    }
}