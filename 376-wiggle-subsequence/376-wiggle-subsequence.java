class Solution {
    public int wiggleMaxLength(int[] nums) {
        int prev = 0, ans = 1, cur = 0, n = nums.length;
        for (int i = 1; i < n; ++i) {
            cur = nums[i] - nums[i - 1];
            if ((cur > 0 && prev <= 0) || (cur < 0 && prev >= 0)) {
                ++ans;
                prev = cur;
            }
        }
        return ans;
    }
}