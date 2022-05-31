class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;
        HashSet<Integer> set = new HashSet<>();
        int n = s.length();
        int val = 0, totalSize = (1 << k);
        for(int i = 0; i < k; i++)
            val = (val << 1) | (s.charAt(i) - '0');
        set.add(val);
         for(int i = k; i < n && set.size() < totalSize; i++) {
             val = (val << 1) | (s.charAt(i) - '0');
             int mask = (1 << k);
             val &= (~mask);
             // val -= ((s.charAt(i - k) - '0') << k);
             set.add(val);
        }
        return set.size() == totalSize;
    }
}