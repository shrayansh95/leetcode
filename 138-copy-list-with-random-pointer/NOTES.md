```java
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.next != null) 
                map.get(temp).next = map.get(temp.next);
            if (temp.random != null)
                map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
```
O(n) time O(1) space 3 loops
```java
class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head, copy, dummy = new Node(0);
        // Creating deep copies besides the original nodes 
        while (iter != null) {
            copy = new Node(iter.val);
            copy.next = iter.next;
            iter.next = copy;
            iter = iter.next.next;
        }
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        iter = head;
        Node temp = dummy;
        while (iter != null) {
            temp.next = iter.next;
            iter.next = iter.next.next;
            temp = temp.next;
            iter = iter.next;
        }
        return dummy.next;
    }
}
```
