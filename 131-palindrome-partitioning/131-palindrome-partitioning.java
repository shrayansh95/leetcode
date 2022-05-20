class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, ans, new ArrayList<>());
        return ans;
    }
    private void solve(String s, List<List<String>> ans, List<String> temp) {
        if (s == "") {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        String prefix, res;
        for (int i = 1; i <= s.length(); ++i) {
            prefix = s.substring(0, i);
            res = s.substring(i);
            if (isPalindrome(prefix)) {
                temp.add(prefix);
                solve(res, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            ++i;
            --j;
        }
        return true;
    } 
}