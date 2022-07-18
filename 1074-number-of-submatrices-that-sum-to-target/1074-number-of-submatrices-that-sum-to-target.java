class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; ++i) 
            for (int j = 1; j < m; ++j)
                matrix[i][j] += matrix[i][j - 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int colStart = 0; colStart < m; ++colStart) {
            for (int colEnd = colStart; colEnd < m; ++colEnd) {
                int csum = 0;
                map.clear();
                map.put(0, 1);
                for (int row = 0; row < n; ++row) {
                    csum += (matrix[row][colEnd] - 
                             (colStart == 0 ? 0 : matrix[row][colStart - 1]));
                    ans += map.getOrDefault(csum - target, 0);
                    map.put(csum, map.getOrDefault(csum, 0) + 1);
                }
            }
        }
        return ans;
    }
}