class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE, n = nums.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] < third)
                return true;
            while (!st.isEmpty() && st.peek() < nums[i]) 
                third = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}