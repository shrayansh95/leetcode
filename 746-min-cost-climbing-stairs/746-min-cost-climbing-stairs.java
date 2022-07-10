class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        int one = 0, two = 0;
        for (int i = 0; i < n; ++i) {
            if (i - 1 >= 0)
                one = dp[i - 1];
            if (i - 2 >= 0)
                two = dp[i - 2];
            dp[i] = cost[i] + Math.min(one, two);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}