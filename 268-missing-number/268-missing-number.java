class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        int i = 0;
        for (i = 0; i < n; ++i)
            xor ^= (i ^ nums[i]);
        return xor ^ i;
    }
}