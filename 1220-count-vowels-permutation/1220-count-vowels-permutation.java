class Solution {
    private final int mod = (int)(1e9 + 7);
    public int countVowelPermutation(int n) {
        long prevA = 1, prevE = 1, prevI = 1, prevO = 1, prevU = 1;
        long curA = 0, curE = 0, curI = 0, curO = 0, curU = 0;
        for (int i = 2; i <= n; ++i) {
            curA = (prevE + prevI + prevU) % mod;
            curE = (prevA + prevI) % mod;
            curI = (prevE + prevO) % mod;
            curO = prevI % mod;
            curU = (prevI + prevO) % mod;
            prevA = curA;
            prevE = curE;
            prevI = curI;
            prevO = curO;
            prevU = curU;
        }
        return (int)((prevA + prevE + prevI + prevO + prevU) % mod);
    }
}