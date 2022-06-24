class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int it : nums) {
            if (it >= max1) {
                max2 = max1;
                max1 = it;
            } else if (it > max2)
                max2 = it;
        }
        return (max1 - 1) * (max2 - 1);
    }
}