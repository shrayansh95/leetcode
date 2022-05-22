class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        int n = stockPrices.size();
        if (n == 1)
            return 0;
        int count = 0;
        sort(stockPrices.begin(), stockPrices.end());
        long double prev = -1e9, cur = 0, dx = 0.0, dy = 0.0;
        for (int i = 1; i < n; ++i) {
            dx = stockPrices[i][0] - stockPrices[i - 1][0];
            dy = stockPrices[i][1] - stockPrices[i - 1][1];
            cur = dx / dy;
            if (cur != prev) 
                ++count;
            prev = cur;
        }
        return count;
    }
};