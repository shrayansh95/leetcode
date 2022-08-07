class Solution {
private:
    bool solve(vector<int>& nums, int i, int n, vector<int>& dp) {
        if (i == n) return true;
        if (dp[i] != -1)
            return dp[i];
        if (i + 1 < n && nums[i] == nums[i + 1]) {
            if (solve(nums, i + 2, n, dp))
                return dp[i] = true;
            if (i + 2 < n && nums[i] == nums[i + 2])
                if (solve(nums, i + 3, n, dp))
                    return dp[i] = true;
        }
        if (i + 2 < n &&
            nums[i + 1] - 1 == nums[i] &&
            nums[i + 2] - 2 == nums[i])
            if (solve(nums, i + 3, n, dp))
                return dp[i] = true;
        return dp[i] = false;
    }
public:
    bool validPartition(vector<int>& nums) {
        vector<int> dp(nums.size(), -1);
        return solve(nums, 0, nums.size(), dp);
    }
};