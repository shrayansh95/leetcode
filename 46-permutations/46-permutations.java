class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, nums.length, ans);
        return ans;
    }
    private void solve(int nums[], int i, int n, List<List<Integer>> ans) {
        if (i == n) {
            List<Integer> temp = new ArrayList<>();
            for (int it : nums)
                temp.add(it);
            ans.add(temp);
            return;
        }
        for (int k = i; k < n; ++k) {
            swap(nums, i, k);
            solve(nums, i + 1, n, ans);
            swap(nums, i, k);
        }
    }
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}