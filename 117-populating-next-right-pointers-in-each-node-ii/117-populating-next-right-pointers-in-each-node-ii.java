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
        if (root != null) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node temp;
            int size;
            while (!q.isEmpty()) {
                size = q.size();
                for (int i = 0; i < size; ++i) {
                    temp = q.poll();
                    if (temp.left != null) 
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    if (i == size - 1)
                        temp.next = null;
                    else
                        temp.next = q.peek();
                }
            }
        }
        return root;
    }
}