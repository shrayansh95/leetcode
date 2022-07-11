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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        reversePreorder(root, 0, rightView);
        return rightView;
    }
    private void reversePreorder(TreeNode root, int level, List<Integer> rightView) {
        if (root == null)
            return;
        if (level == rightView.size())
            rightView.add(root.val);
        reversePreorder(root.right, level + 1, rightView);
        reversePreorder(root.left, level + 1, rightView);
    }
}
