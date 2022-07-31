class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int mid, low = 0, high = n, ans = 1;
        long x;
        while (low <= high) {
            mid = low + (high - low) / 2;
            x = (mid * 1L * (mid + 1)) / 2;
            if (x <= n) {
                ans = mid;
                low = mid + 1;
            } else 
                high = mid - 1;
        }
        return ans;
    }
}