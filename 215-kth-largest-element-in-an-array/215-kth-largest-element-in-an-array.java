class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            if (pq.size() < k)
                pq.add(it);
            else if (pq.size() == k && pq.peek() < it) {
                pq.poll();
                pq.add(it);
            }
        }
        return pq.peek();
    }
}