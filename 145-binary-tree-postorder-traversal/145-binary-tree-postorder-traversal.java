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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> postorder = new ArrayList<>();
        while (cur != null) {
            if (cur.right == null) {
                postorder.add(cur.val);
                cur = cur.left;
            } else {
                TreeNode prev = cur.right;
                // Find the rightmost node in the left subtree 
                while (prev.left != null && prev.left != cur) 
                    prev = prev.left;
                if (prev.left == null) {
                    // Connect the rightmost node to the root node 
                    prev.left = cur;
                    postorder.add(cur.val);
                    cur = cur.right;
                } else {
                    // Remove the thread connection and traverse to the
                    // right subtree 
                    prev.left = null;
                    cur = cur.left;
                }
            }
        }
        Collections.reverse(postorder);
        return postorder;
    }
}

