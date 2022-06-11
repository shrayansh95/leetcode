class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int it : nums)
            sum += it;
        sum -= x;
        if (sum == 0)
            return nums.length;
        int i = 0, ans = -1, j = 0, sum1 = 0, n = nums.length;
        while (j < n) {
            sum1 += nums[j];
            while (i < n && sum1 > sum)
                sum1 -= nums[i++];
            if (sum1 == sum)
                ans = Math.max(ans, j - i + 1);
            ++j;
        }
        return (ans == -1 ? -1 : n - ans);
    }
}