class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // Represents the number of people who got to know the secret
        // on the ith day
        int dp[] = new int[n + 1];
        // The first day only one person knows the secret 
        dp[1] = 1;
        // Share stores the number of people who are going to share 
        // the secret on the ith day which is also equal
        // to the number of people who get to know the secret today
        int share = 0;
        int mod = (int)(1e9 + 7);
        for (int i = 2; i <= n; ++i) {
            share = (int)((share * 1L + dp[Math.max(0, i - delay)] 
                           - dp[Math.max(0, i - forget)] + mod) % mod);
            dp[i] = share;
        }
        int ans = 0;
        // We take the last forget days in consideration to get the ans
        // because it has only those number of people who remembers the
        // secret right now 
        for (int i = n - forget + 1; i <= n; ++i)
            ans = (ans + dp[i]) % mod;
        return ans;
    }
}