class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String str : words) 
            if (match(str, pattern))
                ans.add(str);
        return ans;
    }
    
    private boolean match(String w, String p) {
        Map<Character, Character> w_to_p = new HashMap<>(),
        p_to_w = new HashMap<>();
        int n = w.length();
        for (int i = 0; i < n; ++i) {
            if ((w_to_p.containsKey(w.charAt(i)) && w_to_p.get(w.charAt(i)) != p.charAt(i)) ||
                (p_to_w.containsKey(p.charAt(i)) && p_to_w.get(p.charAt(i)) != w.charAt(i)))
                return false;
            else {
                w_to_p.put(w.charAt(i), p.charAt(i));
                p_to_w.put(p.charAt(i), w.charAt(i));
            }
        }
        return true;
    }
}