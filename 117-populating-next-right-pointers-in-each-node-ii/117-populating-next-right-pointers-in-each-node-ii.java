/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node = root, nextLevelHead = new Node(0), needle;
        while (node != null) { //loop for all the levels
            needle = nextLevelHead;
            while (node != null) { // traveling levelwise through all the nodes
                if (node.left != null) {
                    needle.next = node.left;
                    needle = needle.next;
                }
                if (node.right != null) {
                    needle.next = node.right;
                    needle = needle.next;
                }
                node = node.next;
            }
            node = nextLevelHead.next; // go to the next level
            nextLevelHead.next = null;
        }
        return root;
    }
}