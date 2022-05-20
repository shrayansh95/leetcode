class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        solve(candidates, 0, n, target, ans, temp);
        return ans;
    }
    private void solve(int candidates[], int ind, int n, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
            return;
        }
        for (int i = ind; i < n; ++i) {
            if (i > ind && candidates[i] == candidates[i - 1]) 
                continue;
            if (candidates[i] > target)
                break;
            temp.add(candidates[i]);
            solve(candidates, i + 1, n, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}