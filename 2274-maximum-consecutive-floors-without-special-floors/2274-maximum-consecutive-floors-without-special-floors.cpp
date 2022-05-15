class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        int maxi = 0;
        sort(special.begin(), special.end());
        for (int i = 1; i < special.size(); ++i) 
            maxi = max(maxi, special[i] - special[i - 1] - 1);
        maxi = max(special[0] - bottom, maxi);
        maxi = max(top - special.back(), maxi);
        return maxi;
    }
};