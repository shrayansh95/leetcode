class Solution {
    public String countAndSay(int n) {
        String prev = "1", cur = "";
        int i = 1;
        int len, j, count;
        while (i < n) {
            len = prev.length();
            j = 0;
            while (j < len) {
                count = 1;
                while (j < len - 1 && prev.charAt(j) == prev.charAt(j + 1)) {
                    ++j;
                    ++count;
                }
                cur += (String.valueOf(count) + prev.charAt(j++));
            }
            prev = cur;
            cur = "";
            ++i;
        }
        return prev;
    }
}