class Solution {
    public int compareVersion(String version1, String version2) {
        int v1 = 0, v2 = 0, n = version1.length(), m = version2.length();
        int a = 0, b = 0;
        while (v1 < n || v2 < m) {
            a = 0;
            b = 0;
            while (v1 < n && version1.charAt(v1) != '.') 
                a = (a * 10) + (version1.charAt(v1++) - '0');
            while (v2 < m && version2.charAt(v2) != '.')
                b = (b * 10) + (version2.charAt(v2++) - '0');
            if (a < b)
                return -1;
            else if (a > b)
                return 1;
            ++v1;
            ++v2;
        }
        return 0;
    }
}