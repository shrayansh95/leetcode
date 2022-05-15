class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        int n = words.size();
        string g, k;
        int j;
        vector<string> ans;
        for (int i = 0; i < n;) {
            ans.push_back(words[i]);
            g=words[i];
            sort(g.begin(), g.end());
            j = i + 1;
            while (j < n) {
                k = words[j];
                sort(k.begin(), k.end());
                if (k != g)
                    break;
                ++j;
            }
            i = j;
        }
        return ans;
    }
};