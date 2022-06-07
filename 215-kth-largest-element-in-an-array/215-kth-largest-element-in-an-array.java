class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.add(it);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}