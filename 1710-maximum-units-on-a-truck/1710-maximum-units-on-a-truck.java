class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0, i = 0, n = boxTypes.length;
        while (i < n) {
            if (boxTypes[i][0] > truckSize) {
                ans += (truckSize * boxTypes[i][1]);
                break;
            }
            ans += (boxTypes[i][0] * boxTypes[i][1]);
            truckSize -= boxTypes[i++][0];
        }
        return ans;
    }
}