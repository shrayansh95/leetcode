class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, n = s.length(), ans = 0;
        int lastInd[] = new int[256];
        Arrays.fill(lastInd, -1);
        for (; j < n; ++j) {
            if (lastInd[(int)s.charAt(j)] != -1) 
                i = Math.max(i, lastInd[(int)s.charAt(j)] + 1);
            lastInd[(int)s.charAt(j)] = j;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}