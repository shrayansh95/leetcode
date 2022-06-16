class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        int maxi = 0;
        string ans;
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; ++i, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                    if (maxi < 1) {
                        maxi = 1;
                        ans = s[i];
                    }
                } else if (g == 1) {
                    if (s[i] == s[j]) {
                        dp[i][j] = true;
                        if (maxi < 2) {
                            maxi = 2;
                            ans = s.substr(i, g + 1);
                        }
                    }
                } else {
                    if (s[i] == s[j] and dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (maxi < g + 1) {
                            maxi = g + 1;
                            ans = s.substr(i, g + 1);
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return ans;
    }
};