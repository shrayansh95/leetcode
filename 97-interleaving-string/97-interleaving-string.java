class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int dp[][] = new int[101][101];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        return solve(s1, s2, s3, 0, 0, dp);
    }
    private boolean solve(String s1, String s2, String s3, int i, int j, int dp[][]) {
        if (i == s1.length() && j == s2.length()) 
            return true;
        if (dp[i][j] != -1)
            return dp[i][j] == 1 ? true : false;
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            ans |= solve(s1, s2, s3, i + 1, j, dp);
            if (ans) {
                dp[i][j] = 1;
                return ans;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            ans |= solve(s1, s2, s3, i, j + 1, dp);
            if (ans) {
                dp[i][j] = 1;
                return ans; 
            }
        }
        dp[i][j] = 0;
        return ans;
    }
}