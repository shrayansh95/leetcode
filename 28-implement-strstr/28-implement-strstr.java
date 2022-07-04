class Solution {
    public int strStr(String haystack, String needle) {
        return matchPattern(haystack.toCharArray(), needle.toCharArray());
    }
    
    private int matchPattern(char[] text, char[] pattern) {
        char newString[] = new char[text.length + 1 + pattern.length];
        int i = 0;
        for (char ch : pattern)
            newString[i++] = ch;
        newString[i++] = '$';
        for (char ch : text)
            newString[i++] = ch;
        int Z[] = calculateZ(newString);
        for (int it : Z) 
            System.out.print(it + " ");
        System.out.println();
        int n = Z.length, m = pattern.length;
        for (i = 0; i < n; ++i) 
            if (Z[i] == m)
                return (i - m - 1);
        return -1;
    }
    
    private int[] calculateZ(char[] str) {
        int n = str.length;
        int Z[] = new int[n];
        int left = 0, right = 0, k, k1;
        for (k = 1; k < n; ++k) {
            if (k > right) {
                left = right = k;
                while (right < n && str[right] == str[right - left])
                    ++right;
                Z[k] = right - left;
                --right;
            } else {
                k1 = k - left;
                if (Z[k1] + k - 1 < right)
                    Z[k] = Z[k1];
                else {
                    left = k;
                    while (right < n && str[right] == str[right - left])
                        ++right;
                    Z[k] = right - left;
                    --right;
                }
            }
        }
        return Z;
    }
}