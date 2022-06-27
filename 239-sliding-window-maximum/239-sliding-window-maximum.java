class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // Remove out of bound elements 
            if (!dq.isEmpty() && dq.peek() == i - k)
                dq.poll();
            // Remove the smaller elements 
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offer(i);
            if (i >= k - 1)
                ans[j++] = nums[dq.peek()];
        }
        return ans;
    }
}