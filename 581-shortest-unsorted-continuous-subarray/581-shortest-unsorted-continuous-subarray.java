class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int end = -2, start = -1, n = nums.length, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            max = Math.max(nums[i], max);
            if (max > nums[i])
                end = i;
        }
        for (int i = n - 1; i >= 0; --i) {
            min = Math.min(nums[i], min);
            if (min < nums[i])
                start = i;
        }
        return (end - start + 1);
    }
}