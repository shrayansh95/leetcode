class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean cols[] = new boolean[n], left[] = new boolean[2 * n - 1], right[] = new boolean[2 * n - 1];
        List<List<String>> ans = new ArrayList<>();
        solve(0, n, cols, left, right, new ArrayList<>(), ans);
        return ans;
    }
    
    private void solve(int row, int n, boolean cols[], boolean left[], boolean right[], List<String> temp, List<List<String>> ans) {
        if (row == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (!cols[col] && !right[col + row] && !left[n - 1 + col - row]) {
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[col] = 'Q';
                temp.add(new String(charArray));
                cols[col] = true;
                right[col + row] = true;
                left[n - 1 + col - row] = true;
                solve(row + 1, n, cols, left, right, temp, ans);
                temp.remove(temp.size() -1);
                cols[col] = false;
                right[col + row] = false;
                left[n - 1 + col - row] = false;
            }
        }
    }
}