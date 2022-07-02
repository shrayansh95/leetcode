class Solution {
    private final int MOD = 31;
    private final int BASE = 29;
    public int repeatedStringMatch(String a, String b) {
        if (a == b)
            return 1;
        
        String source = a;
        int count = 1;
        // We keep adding the same thing until the length 
        // becomes greater than or equal to that of b 
        while (source.length() < b.length()) {
            ++count;
            source += a;
        }
        
        if ((source == b) || (rabinKarp(source, b) != -1))
            return count;

        if (rabinKarp(source + a, b) != -1)
            return count + 1;
        
        return -1;
    }
    
    private int rabinKarp(String a, String b) {
        int n = a.length(), m = b.length();
        
        int power[] = new int[m];
        power[0] = 1;
        for (int i = 1; i < m; ++i) 
            power[i] = (int)((BASE * 1L * power[i - 1]) % MOD);
        
        int patHash = getHash(b, power);
        int winHash = getHash(a.substring(0, m), power);
        int left, right;
        for (int i = 0; i <= n - m; ++i) {
            if (patHash == winHash && check(a, i, b, m)) 
                return 1;
            
            left = (int)((a.charAt(i) - 'a' + 1) * 1L * power[m - 1]) % MOD;
            winHash = (winHash + MOD - left) % MOD;
            
            // Checking for overflow condition 
            if (i + m < n) {
                right = (int)(((a.charAt(i + m) - 'a' + 1) * 1L) % MOD);
                winHash = (winHash * BASE) % MOD;
                winHash = (winHash + right) % MOD;
            }
        }
        return -1;
    }
    
    private int getHash(String a, int power[]) {
        int n = a.length(), sum = 0;
        for (int i = n - 1; i >= 0; --i) 
            sum = (int)((sum + 
                         ((a.charAt(i) - 'a' + 1) * 1L * power[n - i - 1]) % MOD) % MOD);
        return sum;
    }
    
    private boolean check(String txt, int k, String pat, int m) {
        for (int i = 0; i < m; ++i) {
            if (txt.charAt(i + k) != pat.charAt(i))
                return false;
        }
        return true;
    }
}