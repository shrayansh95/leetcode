class MyStack {
    // Queue<Integer> q1, q2;
    Queue<Integer> queue;
    
    
    public MyStack() {
        // q1 = new LinkedList<>();
        // q2 = new LinkedList<>();
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // q2.add(x);
        // while (!q1.isEmpty()) 
        //     q2.add(q1.poll());
        // Queue<Integer> q = q1;
        // q1 = q2;
        // q2 = q;
        queue.add(x);
        int n = queue.size();
        for (int i = 1; i < n; ++i) 
            queue.add(queue.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */