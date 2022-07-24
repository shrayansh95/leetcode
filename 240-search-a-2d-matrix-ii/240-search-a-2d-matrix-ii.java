class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix[0].length - 1, n = matrix.length;
        while (start < n && end >= 0) {
            if (matrix[start][end] == target)
                return true;
            else if (matrix[start][end] < target) 
                ++start;
            else
                --end;
        }
        return false;
    }
}