class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, n, ans, temp);
        return ans;
    }
    private void solve(int nums[], int ind, int n, List<List<Integer>> ans, List<Integer> temp) {
        List<Integer> temp1 = new ArrayList<Integer>(temp);
        ans.add(temp1);
        for (int i = ind; i < n; ++i) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            solve(nums, i + 1, n, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}