class DSU {
public:
    vector<int> parent;
    vector<int> rank;
    DSU() {
        parent.resize(26, 0);
        rank.resize(26, 0);
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int findPar(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findPar(parent[x]);
    }
    void Union(int a, int b) {
        a = findPar(a);
        b = findPar(b);
        if (a == b) {
            return;
        }
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            ++rank[a];
        }
    }
};
class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        DSU obj;
        for (string &it : equations) {
            if (it[1] == '=') {
                obj.Union((it[0] - 'a'), (it[3] - 'a'));
            }
        }
        int a, b;
        for (string &it : equations) {
            if (it[1] == '!') {
                a = obj.findPar(it[0] - 'a');
                b = obj.findPar(it[3] - 'a');
                if (a == b) {
                    return false;
                }
            }
        }
        return true;
    }
};
