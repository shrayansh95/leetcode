class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for (char it[] : board) 
            Arrays.fill(it, '.');
        solve(board, 0, n, ans);
        return ans;
    }
    
    private void solve(char board[][], int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(construct(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (valid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, row + 1, n, ans);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean valid(char board[][], int row, int col, int n) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'Q' && ((j == col) || (row + j == col + i) || (row + col == i + j)))
                    return false;
            }
        }
        return true;
    } 
    
    private List<String> construct(char board[][]) {
        List<String> temp = new ArrayList<>();
        for (char it[] : board) {
            temp.add(new String(it));
        }
        return temp;
    }
}