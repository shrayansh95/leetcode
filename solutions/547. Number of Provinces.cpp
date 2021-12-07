class DSU {
public:
    vector<int> parent;
    vector<int> rank;
    int s;
    DSU(int n) {
        parent.resize(n, 0);
        rank.resize(n, 0);
        s = n;
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
    void Union(int a, int b) {
        a = findPar(a);
        b = findPar(b);
        if (a == b) {
            return;
        }
        --s;
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            ++rank[a];
