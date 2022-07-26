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
    public int kthSmallest(TreeNode root, int k) {
        int cnt[] = new int[1];
        int ans[] = new int[]{-1};
        inorder(root, k, ans, cnt);
        return ans[0];
    }
    private void inorder(TreeNode root, int k, int ans[], int cnt[]) {
        if (root == null) return;
        inorder(root.left, k, ans, cnt);
        ++cnt[0];
        if (cnt[0] == k)
            ans[0] = root.val;
        inorder(root.right, k, ans, cnt);
    }
}