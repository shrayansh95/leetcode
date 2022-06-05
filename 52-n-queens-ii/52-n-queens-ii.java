class Solution {
    public int totalNQueens(int n) {
        boolean up[] = new boolean[n];
        boolean left[] = new boolean[2 * n - 1];
        boolean right[] = new boolean[2 * n - 1];
        int ans[] = new int[1];
        solve(0, n, up, left, right, ans);
        return ans[0];
    }
    
    private void solve(int row, int n, boolean up[], boolean left[], boolean right[], int ans[]) {
        if (row == n) {
            ++ans[0];
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (!up[col] && !right[row + col] && !left[n - 1 + row - col]) {
                up[col] = true;
                right[row + col] = true;
                left[n - 1 + row - col] = true;
                solve(row + 1, n, up, left, right, ans);
                up[col] = false;
                right[row + col] = false;
                left[n - 1 + row - col] = false;
            }
        }
    }
}