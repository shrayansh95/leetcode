/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

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