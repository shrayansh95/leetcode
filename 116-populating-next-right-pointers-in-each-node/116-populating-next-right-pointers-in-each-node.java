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
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int size;
        Node temp;
        
        while (q.peek() != null) {
            size = q.size();
            
            for (int i = 0; i < size; ++i) {
                temp = q.poll();
                if (temp == null) {
                    q.add(null);
                    break;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                temp.next = q.peek();
            } 
        }
        return root;
    }
}