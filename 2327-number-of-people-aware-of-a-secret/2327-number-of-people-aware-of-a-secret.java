class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int share = 0;
        int mod = (int)(1e9 + 7);
        for (int i = 2; i <= n; ++i) {
            share = (int)((share * 1L + dp[Math.max(0, i - delay)] 
                           - dp[Math.max(0, i - forget)] + mod) % mod);
            dp[i] = share;
        }
        int ans = 0;
        for (int i = n - forget + 1; i <= n; ++i)
            ans = (int)((ans * 1L + dp[i]) % mod);
        return ans;
    }
}