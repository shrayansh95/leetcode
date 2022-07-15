class Solution {
    private final int dir[] = new int[]{0, 1, 0, -1, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0, temp[] = new int[1];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    temp[0] = 0;
                    dfs(grid, i, j, temp);
                    ans = Math.max(ans, temp[0]);
                }
            }
        }
        return ans;
    }
    
    private void dfs(int grid[][], int i, int j, int temp[]) {
        ++temp[0];
        grid[i][j] = 0;
        int nr, nc;
        for (int k = 0; k < 4; ++k) {
            nr = i + dir[k];
            nc = j + dir[k + 1];
            if (nr >= grid.length 
                || nr < 0
                || nc >= grid[0].length
                || nc < 0
                || grid[nr][nc] == 0)
                continue;
            dfs(grid, nr, nc, temp);
        }
    }
}