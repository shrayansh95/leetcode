class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(nums, 0, nums.length, ans);
        return ans;
    }
    private void solve(int nums[], int i, int n, List<List<Integer>> ans) {
        if (i == n) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int it : nums)
                temp.add(it);
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int k = i; k < n; ++k) {
            if (appeared.add(nums[k])) {
                swap(nums, i, k);
                solve(nums, i + 1, n, ans);
                swap(nums, i, k);
            }
        }
    }
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}