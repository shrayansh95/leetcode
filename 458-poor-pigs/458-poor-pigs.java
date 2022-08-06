class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int eachPig = minutesToTest / minutesToDie + 1;
        while (Math.pow(eachPig, pigs) < buckets)
            ++pigs;
        return pigs;
    }
}