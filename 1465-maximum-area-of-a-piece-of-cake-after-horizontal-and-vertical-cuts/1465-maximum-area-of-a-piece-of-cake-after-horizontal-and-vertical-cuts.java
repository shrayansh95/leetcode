class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int)(1e9 + 7);
        return (int)((helper(horizontalCuts, h) * 1L * helper(verticalCuts, w))
                     % mod);
    }
    private int helper(int a[], int n) {
        Arrays.sort(a);
        int l = a.length;
        int max = Math.max(a[0], n - a[l - 1]);
        for (int i = 1; i < l; ++i) 
            max = Math.max(max, a[i] - a[i - 1]);
        return max;
    }
}