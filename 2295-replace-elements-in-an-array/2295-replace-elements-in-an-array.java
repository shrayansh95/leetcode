class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i)
            map.put(nums[i], i);
        n = operations.length;
        int idx;
        for (int i = 0; i < n; ++i) {
            idx = map.get(operations[i][0]);
            nums[idx] = operations[i][1];
            map.put(operations[i][1], idx);
        }
        return nums;
    }
}