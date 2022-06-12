class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = nums.length, ans = 0, temp = 0;
        for (; j < n; ++j) {
            temp += nums[j];
            while (map.containsKey(nums[j]) && map.get(nums[j]) >= i) 
                temp -= nums[i++];
            map.put(nums[j], j);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}