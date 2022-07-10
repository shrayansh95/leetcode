class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = 0, prev2 = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        return Math.min(prev1, prev2);
    }
}