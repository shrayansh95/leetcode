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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; ++i) 
            map.put(inorder[i], i);
        
        TreeNode root = build(preorder, 0, n - 1, inorder, 0, n - 1, map);
        
        return root;
    }
    
    private TreeNode build(int preorder[], int preStart, int preEnd, 
                          int inorder[], int inStart, int inEnd,
                          Map<Integer, Integer> map) {
        if (inStart > inEnd || preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int left = idx - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + left, 
                         inorder, inStart, idx - 1, map);
        
        root.right = build(preorder, preStart + left + 1, preEnd,
                          inorder, idx + 1, inEnd, map);
        
        return root;
    }
}