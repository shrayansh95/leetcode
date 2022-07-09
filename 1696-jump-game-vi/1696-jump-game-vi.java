class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(n - 1);
        int cur = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            cur = nums[i] + nums[dq.peekFirst()];
            // Remove all the smaller elements in deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < cur) 
                dq.pollLast();
            dq.offer(i);
            if (dq.peekFirst() >= i + k)
                dq.pollFirst();
            nums[i] = cur;
        }
        return cur;
    }
}