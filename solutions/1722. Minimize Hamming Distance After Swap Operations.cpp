public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        int n = source.size();
        map<int, map<int, int>> mp;
        DSU obj(n);
        for (int i = 0; i < allowedSwaps.size(); i++) {
            int x, y;
            x = allowedSwaps[i][0], y = allowedSwaps[i][1];
            obj.Union(x, y);
        }
        for (int i = 0; i < n; i++) {
            int root = obj.findPar(i);
            int num = source[i];
            if (mp[root].find(num) == mp[root].end()) {
                mp[root][num] = 1;
            } else {
                ++mp[root][num];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int root = obj.findPar(i);
            int num = target[i];
            if (mp[root].find(num) == mp[root].end()) {
                ++ans;
                continue;
            } else if (mp[root][num] == 0) {
                ++ans;
                continue;
            } else {
                --mp[root][num];
            }
        }
        return ans;
    }
};
