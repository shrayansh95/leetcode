class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int i = n - k, sum = 0;
        while (i < n) 
            sum += cardPoints[i++];
        int ans = sum;
        while (i < n + k) {
            sum += (cardPoints[i % n] - cardPoints[(i - k) % n]);
            ans = Math.max(ans, sum);
            ++i;
        }
        return ans;
    }
}