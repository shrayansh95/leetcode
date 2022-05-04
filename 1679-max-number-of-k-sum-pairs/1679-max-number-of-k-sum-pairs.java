class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int it : nums) {
            if (map.containsKey(k - it) && map.get(k - it) != 0) {
                ++ans;
                map.put(k - it, map.get(k - it) - 1);
            } else {
                map.put(it, map.getOrDefault(it, 0) + 1);
            }
        }
        return ans;
    }
}