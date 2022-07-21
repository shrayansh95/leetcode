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
    public TreeNode bstFromPreorder(int[] preorder) {
        int i[] = new int[1];
        return build(preorder, i, Integer.MAX_VALUE);
    }
    
    private TreeNode build(int preorder[], int i[], int upperBound) {
        if (i[0] == preorder.length || upperBound < preorder[i[0]])
            return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        ++i[0];
        root.left = build(preorder, i, root.val);
        root.right = build(preorder, i, upperBound);
        return root;
    }
}