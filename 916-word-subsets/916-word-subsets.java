class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;
        int maxFreq[] = new int[26];
        
        for (String word : words2) {
            int freq[] = countFreq(word);
            for (int i = 0; i < 26; ++i)
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words1) {
            int freq[] = countFreq(word);
            int i = 0;
            for (; i < 26; ++i)
                if (freq[i] < maxFreq[i])
                    break;
            if (i == 26)
                ans.add(word);
        }
        return ans;
    }
    private int[] countFreq(String word) {
        int freq[] = new int[26];
        int n = word.length();
        for (int i = 0; i < n; ++i)
            ++freq[word.charAt(i) - 'a'];
        return freq;
    }
}