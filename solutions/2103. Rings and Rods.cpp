class Solution {
public:
    int countPoints(string rings) {
        map<int, set<char>> mp;
        int len = rings.length();
        int ind;
        char c;
        for (int i = 0; i < len; i += 2) {
            c = rings[i];
            ind = rings[i + 1] - '0';
            mp[ind].insert(c);
        }
        int count = 0;
        for (auto it : mp) {
            if (it.second.size() == 3) {
                ++count;
            }
        }
        return count;
    }
};
