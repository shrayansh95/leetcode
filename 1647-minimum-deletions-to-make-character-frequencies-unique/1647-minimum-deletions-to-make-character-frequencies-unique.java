class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        int ans = 0;
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i)
            ++freq[s.charAt(i) - 'a'];
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0 && !set.add(freq[i])) {
                ++ans;
                --freq[i];
            }
        }
        return ans;
    }
}