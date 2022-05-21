class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        int ans = solve(coins, n - 1, amount, dp);
        return (ans == (int)1e9 ? -1 : ans);
    }
    private int solve(int coins[], int i, int amount, int dp[][]) {
        if (i == 0) {
            if (amount % coins[i] == 0)
                return (amount / coins[i]);
            return (int)1e9;
        } else if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int notTake = solve(coins, i - 1, amount, dp);
        int take = (int)1e9;
        if (coins[i] <= amount)
            take = 1 + solve(coins, i, amount - coins[i], dp);
        return dp[i][amount] = Math.min(take, notTake);
    }
}