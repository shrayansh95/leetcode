class Node {
    Node prev, next;
    int key, val;
    Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    Node () {
        this.key = 0;
        this.val = 0;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int size;
    Map<Integer, Node> map;
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node temp = map.get(key);
        int value = temp.val;
        delete(temp.prev, temp, temp.next);
        temp = new Node(key, value);
        add(key, temp);
        return value;
    }
    
    public void put(int key, int value) {
        Node temp;
        if (map.containsKey(key)) {
            temp = map.get(key);
            delete(temp.prev, temp, temp.next);
            temp = new Node(key, value);
        } else if (map.size() < size) {
            temp = new Node(key, value);
        } else {
            delete(tail.prev.prev, tail.prev, tail);
            temp = new Node(key, value); 
        }
        add(key, temp);
    }
    
    private void delete(Node pred, Node cur, Node succ) {
        pred.next = succ;
        succ.prev = pred;
        cur.next = null;
        cur.prev = null;
        map.remove(cur.key);
    }
    
    private void add(int key, Node temp) {
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
        temp.prev = head;
        map.put(key, temp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */