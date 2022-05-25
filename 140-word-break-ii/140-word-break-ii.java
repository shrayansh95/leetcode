class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> map = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        dfs(s, "", ans, map);
        return ans;
    }
    
    private void dfs(String s, String str, List<String> ans, HashSet<String> map) {
        if (s.length() == 0) {
            StringBuilder temp = new StringBuilder(str);
            temp.deleteCharAt(temp.length() - 1);
            ans.add(temp.toString());
            return;
        }
        int n = s.length();
        String pre, res;
        for (int i = 1; i <= n; ++i) {
            pre = s.substring(0, i);
            if (map.contains(pre)) {
                res = s.substring(i);
                dfs(res, str + pre + " ", ans, map);
            }
        }
    }
}