class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                count += isPalin(s, i, j);
            }
        }
        return count;
    }
    int isPalin(String s, int i, int j) {
        if (i >= j)
            return 1;
        return s.charAt(i) == s.charAt(j) ? isPalin(s, i + 1, j - 1) : 0;
    }
}