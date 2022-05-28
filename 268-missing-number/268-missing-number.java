class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        int n = nums.length;
        for (int i = 0; i <= n; ++i)
            xor1 ^= i;
        for (int it : nums)
            xor2 ^= it;
        return xor1 ^ xor2;
    }
}