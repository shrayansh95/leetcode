class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        int mask;
        int ans = 0;
        int count = 0;
        for (int i = 29; i>= 0; --i) {
            mask = 1 << i;
            count = 0;
            for (int it : candidates) {
                if (it & mask) 
                    ++count;
            }
            ans = max(ans, count);
        }
        return ans;
    }
};