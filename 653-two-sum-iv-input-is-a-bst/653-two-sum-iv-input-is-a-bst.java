/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> st1, st2;
    BSTIterator(TreeNode root) {
        st1 = new Stack<>();
        st2 = new Stack<>();
        pushAllLeft(root);
        pushAllRight(root);
    }
    
    public int next() {
        TreeNode temp = st1.pop();
        pushAllLeft(temp.right);
        return temp.val;
    }
    
    public int before() {
        TreeNode temp = st2.pop();
        pushAllRight(temp.left);
        return temp.val;
    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            st1.push(root);
            root = root.left;
        }
    }
    
    private void pushAllRight(TreeNode root) {
        while (root != null) {
            st2.push(root);
            root = root.right;
        }
    }
} 

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator bst = new BSTIterator(root);
        int low = bst.next(), high = bst.before();
        while (low < high) {
            if (low + high == k)
                return true;
            else if (low + high < k) 
                low = bst.next();
            else
                high = bst.before();
        }
        return false;
    }
}