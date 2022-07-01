class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2)
            return s;
        int odd, even, start = 0, end = 0, curLen;
        for (int i = 0; i < n; ++i) {
            odd = expandFromMiddle(s, i, i);
            even = expandFromMiddle(s, i, i + 1);
            curLen = Math.max(odd, even);
            if (curLen > end - start + 1) {
                end = i + (curLen / 2);
                start = i - ((curLen - 1) / 2);
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandFromMiddle(String s, int left, int right) {
        int n = s.length();
        if (n < 2)
            return n;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}