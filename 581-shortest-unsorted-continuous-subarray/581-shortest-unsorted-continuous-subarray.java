class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int end = -2, start = -1, n = nums.length, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n - i - 1], min);
            if (nums[i] < max)
                end = i;
            if (nums[n - i - 1] > min)
                start = n - i - 1;
        }
        return (end - start + 1);
    }
}