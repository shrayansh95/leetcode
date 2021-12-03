    }
    void Union(int a, int b) {
        a = findPar(a), b = findPar(b);
        if (a == b) {
            return;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[b] > rank[a]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            ++rank[a];
        }
    }
};
​
class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int n = accounts.size();
        DSU obj(n);
        unordered_map<string, int> emailToName;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts[i].size(); j++) {
                if (emailToName.find(accounts[i][j]) != emailToName.end()) {
                    obj.Union(i, emailToName[accounts[i][j]]);
                } else {
                    emailToName[accounts[i][j]] = i;
                }
            }
        }
        unordered_map<int, set<string>> mp;
        for (auto &it : emailToName) {
            int p = obj.findPar(it.second);
            mp[p].insert(it.first);
        }
        
        vector<vector<string>> ans;
        string g;
        for (auto &it : mp) {
            vector<string> temp(it.second.begin(), it.second.end());
            g = accounts[it.first][0];
            temp.insert(temp.begin(), g);
            ans.push_back(temp);
        }
        return ans;
    }
};
