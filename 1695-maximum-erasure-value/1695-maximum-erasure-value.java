class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0, n = nums.length, ans = 0, temp = 0;
        for (; j < n; ++j) {
            temp += nums[j];
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                temp -= nums[i++];
            } 
            set.add(nums[j]);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}