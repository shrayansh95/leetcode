class Solution {
public:
    void dfs(int i, int j, vector<vector<int>> &graph) {
        graph[i][j] = 1;
        vector<int> dir = {0, 1, 0, -1, 0};
        int nr, nc;
        for (int k = 0; k < 4; k++) {
            nr = i + dir[k];
            nc = j + dir[k + 1];
            if (nr < 0 or nc < 0 or nr >= graph.size() or nc >= graph.size() or graph[nr][nc]) {
                continue;
            }
            dfs(nr, nc, graph);
        }
    }
    
    int regionsBySlashes(vector<string>& grid) {
        int n = grid.size();
        vector<vector<int>> graph(n * 3, vector<int>(n * 3, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '/') {
                    graph[i * 3][j * 3 + 2] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3] = 1;
                } else if (grid[i][j] == '\\') {
                    graph[i * 3][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
