class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        int ht, w;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; ++i) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                ht = heights[st.pop()];
                if (st.isEmpty())
                    w = i;
                else 
                    w = i - st.peek() - 1;
                ans = Math.max(ans, ht * w);
            }
            st.push(i);
        }
        return ans;
    }
}