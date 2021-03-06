class MedianFinder {
    PriorityQueue<Integer> small, large;
    boolean even;
    
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) 
            return ((small.peek() + large.peek()) / 2.0);
        else 
            return large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */