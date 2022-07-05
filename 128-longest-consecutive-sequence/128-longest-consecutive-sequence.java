class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, left, right, len;
        for (int it : nums) {
            if (!map.containsKey(it)) {
                left = map.getOrDefault(it - 1, 0);
                right = map.getOrDefault(it + 1, 0);
                len = left + right + 1;
                ans = Math.max(ans, len);
                map.put(it, len);
                map.put(it - left, len);
                map.put(it + right, len);
            }
        }
        return ans;
    }
}