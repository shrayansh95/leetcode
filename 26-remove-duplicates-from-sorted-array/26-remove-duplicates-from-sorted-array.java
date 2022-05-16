class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, j = 0, i = 0;
        for (j = 1; j < n; ++j) {
            if (nums[j] != nums[i]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}