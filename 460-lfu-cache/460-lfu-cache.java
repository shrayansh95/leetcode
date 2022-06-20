class Node {
    int key, value, freq;
    Node next, prev;
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        next = null;
        prev = null;
    }
}

class DoublyLinkedList {
    int listSize;
    Node head, tail;
    public DoublyLinkedList() {
        this.listSize = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node curNode) {
        curNode.next = head.next;
        head.next.prev = curNode;
        head.next = curNode;
        curNode.prev = head;
        ++listSize;
    }
    
    public void remove(Node curNode) {
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        --listSize;
    }
}

class LFUCache {
    Map<Integer, Node> map;
    Map<Integer, DoublyLinkedList> freqMap;
    int size;
    int minFreq;

    public LFUCache(int capacity) {
        this.size = capacity;
        this.minFreq = 0;
        this.freqMap = new HashMap<>();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        updateNode(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if (size == 0)
            return;
        if (map.containsKey(key)) {
            map.get(key).value = value;
            updateNode(map.get(key));
        } else {
            if (map.size() == size) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                map.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
            }
            minFreq = 1;
            DoublyLinkedList minFreqList = freqMap.getOrDefault(1, new DoublyLinkedList());
            Node newNode = new Node(key, value);
            minFreqList.add(newNode);
            freqMap.put(1, minFreqList);
            map.put(key, newNode);
        }
    }
    
    private void updateNode(Node temp) {
        int curFreq = temp.freq;
        DoublyLinkedList list = freqMap.get(curFreq);
        list.remove(temp);
        
        if (curFreq == minFreq && list.listSize == 0)
            ++minFreq;
        ++temp.freq;
        DoublyLinkedList newList = freqMap.getOrDefault(temp.freq, new DoublyLinkedList());
        newList.add(temp);
        freqMap.put(temp.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */