class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, j = 0, i = 0;
        for (i = 0; i < n; ++i) {
            if (j == n)
                break;
            nums[i] = nums[j];
            while (j < n && nums[j] == nums[i]) 
                ++j;
        }
        return i;
    }
}