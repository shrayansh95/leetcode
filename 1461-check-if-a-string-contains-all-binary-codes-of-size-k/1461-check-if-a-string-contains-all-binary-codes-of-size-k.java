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
        int mask;
         for(int i = k; i < n && set.size() < totalSize; i++) {
             val = (val << 1) | (s.charAt(i) - '0');
             mask = (1 << k);
             val &= (~mask);
             set.add(val);
        }
        return set.size() == totalSize;
    }
}