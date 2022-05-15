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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0, size = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode temp;
        while (!q.isEmpty()) {
            sum = 0;
            size = q.size();
            for (int i = 0; i < size; ++i) {
                temp = q.remove();
                sum += temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return sum;
    }
}