        if (a != b) {
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else if (rank[a] < rank[b]) {
                parent[a] = b;
            } else {
                parent[b] = a;
                ++rank[a];
            }
            return false;
        }
        return true;
    }
};
class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        vector<int> indegree(n + 1, -1);
        int bl1 = -1, bl2 = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[edges[i][1]] != -1) {
                bl2 = indegree[edges[i][1]];
                bl1 = i;
                break;
            } else {
                indegree[edges[i][1]] = i;
            }
        }
        DSU obj(n + 1);
        bool isCyclePresent = false;
        for (int i = 0; i < n; i++) {
            if (i == bl1) continue;
            isCyclePresent = obj.Union(edges[i][0], edges[i][1]);
            if (isCyclePresent) {
                if (bl1 == -1) {
                    return edges[i];
                } else {
                    return edges[bl2];
                }
            }
        }
        return edges[bl1];
    }
};
