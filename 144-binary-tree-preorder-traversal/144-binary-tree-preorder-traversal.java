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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> preorder = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                // Find the rightmost node in the left subtree 
                while (prev.right != null && prev.right != cur) 
                    prev = prev.right;
                if (prev.right == null) {
                    // Connect the rightmost node to the root node 
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    // Remove the thread connection and traverse to the
                    // right subtree 
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
}
