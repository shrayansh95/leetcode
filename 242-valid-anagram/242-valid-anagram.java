class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) ++freq[s.charAt(i) - 'a'];
        n = t.length();
        for (int i = 0; i < n; ++i) --freq[t.charAt(i) - 'a'];
        for (int it : freq)
            if (it != 0)
                return false;
        return true;
    }
}