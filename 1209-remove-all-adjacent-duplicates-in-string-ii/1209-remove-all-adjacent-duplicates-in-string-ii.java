class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0, j = 0, n = s.length(), count[] = new int[n];
        char st[] = s.toCharArray();
        for (; j < n; ++i, ++j) {
            st[i] = st[j];
            if (i > 0 && st[i - 1] == st[i])
                count[i] = count[i - 1] + 1;
            else
                count[i] = 1;
            if (count[i] == k)
                i -= k;
        }
        return new String(st, 0, i);
    }
}