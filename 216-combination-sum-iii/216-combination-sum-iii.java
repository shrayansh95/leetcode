class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k, 1, n, new ArrayList<>(), ans);
        return ans;
    }
    private void solve(int k, int start, int n, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == k && n == 0) {
            List<Integer> temp1 = new ArrayList<Integer>(temp);
            ans.add(temp1);
            return;
        }
        if (temp.size() > k || n < 0)
            return;
        for (int i = start; i <= 9; ++i) {
            temp.add(i);
            solve(k, i + 1, n - i, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}