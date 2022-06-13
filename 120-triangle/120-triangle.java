class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int prev[] = new int[n], cur[] = new int[n];
        
        for (int c = 0; c < n; ++c)
            prev[c] = triangle.get(n - 1).get(c);
        
        for (int r = n - 2; r >= 0; --r) {
            for (int c = 0; c < r + 1; ++c) {
                cur[c] = triangle.get(r).get(c) + Math.min(prev[c], prev[c + 1]);
            }
            prev = cur;
        }
        
        return prev[0];
    }
}