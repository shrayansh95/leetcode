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
    public boolean isValidBST(TreeNode root) {
        TreeNode prev[] = new TreeNode[1];
        prev[0] = null;
        return solve(root, prev);
    }
    
    private boolean solve(TreeNode root, TreeNode prev[]) {
        if (root == null)
            return true;
        if (!solve(root.left, prev))
            return false;
        if (prev[0] != null && prev[0].val >= root.val)
            return false;
        prev[0] = root;
        return solve(root.right, prev);
    }
}