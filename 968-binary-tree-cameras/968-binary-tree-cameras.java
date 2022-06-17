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
    public int minCameraCover(TreeNode root) {
        int res[] = new int[1];
        return (dfs(root, res) < 1 ? 1 : 0) + res[0];
    }
    
    private int dfs(TreeNode root, int res[]) {
        if (root == null)
            return 2;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        if (left == 0 || right == 0) {
            ++res[0];
            return 1;
        }
        return ((left == 1 || right == 1) ? 2 : 0);
    }
}