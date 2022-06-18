class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int len = nums2.length;
        for (int i = 0; i < len; ++i) {
            while (!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                map.put(nums2[st.peek()], nums2[i]);
                st.pop();
            }
            st.push(i);
        }
        len = nums1.length;
        int ans[] = new int[len];
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums1[i]))
                ans[i] = map.get(nums1[i]);
            else 
                ans[i] = -1;
        }
        return ans;
    }
}