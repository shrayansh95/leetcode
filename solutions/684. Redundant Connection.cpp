class DSU {
public:
    vector<int> parent;
    vector<int> rank;
    DSU (int n) {
        parent = vector<int>(n, 0), rank = vector<int>(n, 0);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    int findPar(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findPar(parent[x]);
    }
    bool Union(int a, int b) {
        a = findPar(a), b = findPar(b);
        if (a == b) {
            return true;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[b] > rank[a]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            ++rank[a];
        }
        return false;
    }
};
​
class Solution {
