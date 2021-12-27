class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> mp1, mp2;
        for (char c : t) ++mp1[c];
        int i = 0, j = 0, matchCount = 0, minLen = INT_MAX;
        string ans = "";
        for (; j < s.length(); j++) {
            if (mp1.find(s[j]) != mp1.end()) {
                ++mp2[s[j]];
                if (mp2[s[j]] <= mp1[s[j]]) {
                    ++matchCount;
                }
            }
            if (matchCount == t.length()) {
                while (mp1.find(s[i]) == mp1.end() or mp2[s[i]] > mp1[s[i]]) {
                    --mp2[s[i]];
                    ++i;
                }
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    ans = s.substr(i, minLen);
                } 
            }
        }
        return ans;
    }
};
