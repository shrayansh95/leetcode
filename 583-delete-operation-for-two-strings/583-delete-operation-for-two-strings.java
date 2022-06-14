class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int dp[][] = new int[n1][n2];
        for (int it[] : dp)
            Arrays.fill(it, -1);
        return solve(word1, word2, n1 - 1, n2 - 1, dp);
    }
    
    private int solve(String word1, String word2, int n1, int n2, int dp[][]) {
        if (n1 == -1 && n2 == -1)
            return 0;
        if (n1 == -1)
            return 1 + solve(word1, word2, n1, n2 - 1, dp);
        else if (n2 == -1)
            return 1 + solve(word1, word2, n1 - 1, n2, dp);
        else if (word1.charAt(n1) == word2.charAt(n2))
            return solve(word1, word2, n1 - 1, n2 - 1, dp);
        else if (dp[n1][n2] != -1)
            return dp[n1][n2];
        int deleteFromWord1 = (int)1e9, deleteFromWord2 = (int)1e9;
        deleteFromWord1 = 1 + solve(word1, word2, n1 - 1, n2, dp);
        deleteFromWord2 = 1 + solve(word1, word2, n1, n2 - 1, dp);
        return dp[n1][n2] = Math.min(deleteFromWord1, deleteFromWord2);
    }
}