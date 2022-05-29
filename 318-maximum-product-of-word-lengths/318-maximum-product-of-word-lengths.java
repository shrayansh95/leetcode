class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, k;
        int value[] = new int[n];
        String temp;
        for (int i = 0; i < n; ++i) {
            temp = words[i];
            k = temp.length();
            for (int j = 0; j < k; ++j) 
                value[i] |= (1 << (temp.charAt(j) - 'a'));
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((value[i] & value[j]) == 0) 
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}