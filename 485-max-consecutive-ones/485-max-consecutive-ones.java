class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) ++count;
            else 
                count = 0;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}