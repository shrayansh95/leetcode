class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, -1, dp);
    }
    private int solve(int[] nums, int i, int prev, int[] dp) {
        if (i == nums.length) return 0;
        if (dp[prev + 1] != -1) return dp[prev + 1];
        int notTake = solve(nums, i + 1, prev, dp);
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) 
            take = 1 + solve(nums, i + 1, i, dp);
        return dp[prev + 1] = Math.max(take, notTake);
    }
}