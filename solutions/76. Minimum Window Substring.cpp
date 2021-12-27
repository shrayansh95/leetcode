class Solution {
public:
    string minWindow(string s, string t) {
        string ans = "";
        unordered_map<char, int> freqT;
        for (char c : t) {
            ++freqT[c];
        }
        int matchCount = 0, desiredMatchCount = t.length();
        unordered_map<char, int> freqS;
        string temp;
        int i = 0, j = 0;
        bool f1, f2;
        while (true) {
            f1 = false;
            f2 = false;
            // acquire 
            while (j < s.length() and matchCount < desiredMatchCount) {
                ++freqS[s[j]];
                if (freqS[s[j]] <= freqT[s[j]]) {
                    ++matchCount; 
                }
                ++j;
                f1 = true;
            }
        
            // collect ans and release
            while (i < j and matchCount == desiredMatchCount) {
                temp = s.substr(i, j - i);
                if (ans.length() == 0 or temp.length() < ans.length()) {
                    ans = temp;
                }
                --freqS[s[i]];
                if (freqT.find(s[i]) != freqT.end() and freqS[s[i]] < freqT[s[i]]) {
                    --matchCount;
                } 
                f2 = false;
                ++i;
            }
            
            if (!f1 and !f2) {
                break;
            }
        }
        return ans;
    }
};
