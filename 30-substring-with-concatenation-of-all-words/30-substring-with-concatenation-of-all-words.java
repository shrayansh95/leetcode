class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0)
            return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        int wordLen = words[0].length();
        int n = words.length * wordLen;
        int len = s.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= len - n; ++i) {
            String cur = s.substring(i, i + n);
            if (isValid(cur, map, wordLen)) 
                ans.add(i);
        }
        return ans;
    }
    
    private boolean isValid(String cur, Map<String, Integer> map, int wordLen) {
        Map<String, Integer> map1 = new HashMap<>();
        int n = cur.length();
        for (int i = 0; i < n; i += wordLen) {
            String s = cur.substring(i, i + wordLen);
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        return map1.equals(map);
    }
}