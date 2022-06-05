class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int ans = 0, cur;
        while (i < n) {
            cur = nums[i];
            ++ans;
            while (i < n && cur + k >= nums[i])
                ++i;
        }
        return ans;
    }
}