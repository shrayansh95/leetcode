class Solution {
public:
    void dfs(int node, int parent, int& timer, vector<int> adj[], vector<int>& visit, vector<int>& tin, vector<int>& low, vector<vector<int>>& ans) {
        visit[node] = 1;
        tin[node] = low[node] = timer++;
        for (int child : adj[node]) {
            if (parent == child)
                continue;
            if (visit[child]) 
                low[node] = min(low[node], tin[child]);
            else {
                dfs(child, node, timer, adj, visit, tin, low, ans);
                low[node] = min(low[node], low[child]);
                if (low[child] > tin[node]) {
                    vector<int> temp;
                    temp.push_back(node);
                    temp.push_back(child);
                    ans.push_back(temp);
                }
            }
        }
    }
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<int> adj[n];
        for (int i = 0; i < connections.size(); i++) {
            adj[connections[i][0]].push_back(connections[i][1]);
            adj[connections[i][1]].push_back(connections[i][0]);
        }
        vector<int> visit(n, 0), tin(n), low(n);   
        vector<vector<int>> ans;
        int timer = 0;
        dfs(0, -1, timer, adj, visit, tin, low, ans);
        return ans;
    }
};