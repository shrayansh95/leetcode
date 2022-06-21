class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, diff;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n; ++i) {
             diff = heights[i] - heights[i - 1];
            if (diff > 0) 
                pq.add(diff);
            if (pq.size() > ladders) 
                bricks -= pq.poll();
            if (bricks < 0)
                return i - 1;
        }
        return n - 1;
    }
}