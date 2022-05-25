class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char board[][], int row, int col) {
        if (row == 8 && col == 9)
            return true;
        if (col == 9) {
            ++row;
            col = 0;
        }
        if (board[row][col] != '.')
            return solve(board, row, col + 1);
        for (int i = 1; i <= 9; ++i) {
            if (valid(board, row, col, i)) {
                board[row][col] = (char)(i + 48);
                if (solve(board, row, col + 1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean valid(char board[][], int row, int col, int val) {
        for (int i = 0; i < 9; ++i) 
            if ((board[row][i] - '0') == val)
                return false;
        for (int i = 0; i < 9; ++i)
            if ((board[i][col] - '0') == val)
                return false;
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; ++i) {
            for (int j = c; j < c + 3; ++j) {
                if (board[i][j] - '0' == val)
                    return false;
            }
        }
        return true;
    }
}