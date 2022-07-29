class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int p[] = normalize(pattern);
        for (String str : words) 
            if (Arrays.equals(p, normalize(str)))
                ans.add(str);
        return ans;
    }
    private int[] normalize(String str) {
        int n = str.length();
        int res[] = new int[n];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.putIfAbsent(str.charAt(i), map.size());
            res[i] = map.get(str.charAt(i));
        }
        return res;
    }
}