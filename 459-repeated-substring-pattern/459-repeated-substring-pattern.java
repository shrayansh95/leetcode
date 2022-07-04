class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2)
            return false;
        if (n == 2) 
            return s.charAt(0) == s.charAt(1);
        int z[] = new int[n];
        int left = 0, right = 0, k, k1, max = 0, len;
        for (k = 1; k < n; ++k) {
            if (k > right) {
                left = right = k;
                while (right < n && s.charAt(right) == s.charAt(right - left))
                    ++right;
                z[k] = right - left;
                --right;
            } else {
                k1 = k - left;
                if (z[k1] + k - 1 < right) 
                    z[k] = z[k1];
                else {
                    left = k;
                    while (right < n && s.charAt(right) == s.charAt(right - left))
                        ++right;
                    z[k] = right - left;
                    --right;
                }
            }
            max = Math.max(max, z[k]);
        }
        len = n - max;
        return max > 0 && n % len == 0 && z[len] == max;
    }
}