class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) 
            return target[0] == 1;
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int it : target) {
            pq.add(it);
            total += it;
        }
        long rest, largest, largest1;
        int n;
        while (pq.peek() != 1) {
            largest = pq.poll();
            largest1 = pq.peek();
            rest = total - largest;
            n = Math.max(1, (int)((largest - largest1) / rest));
            largest -= (n * rest);
            if (largest < 1)
                return false;
            pq.add((int)largest);
            total = largest + rest;
        }
        return true;
    }
}