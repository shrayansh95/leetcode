class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        solve(candidates, 0, n, target, ans, temp);
        return ans;
    }
    private void solve(int candidates[], int i, int n, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
            return;
        } else if (i == n) 
            return;
        // Take 
        if (candidates[i] <= target) {
            temp.add(candidates[i]);
            solve(candidates, i, n, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
        // Not take
        solve(candidates, i + 1, n, target, ans, temp);
    }
}