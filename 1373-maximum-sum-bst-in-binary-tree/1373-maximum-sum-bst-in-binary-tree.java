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
class NodeValue {
    int maxVal, minVal, maxSum;
    NodeValue(int _minVal, int _maxVal, int _maxSum) {
        this.minVal = _minVal;
        this.maxVal = _maxVal;
        this.maxSum = _maxSum;
    }
}

class Solution {
    public int maxSumBST(TreeNode root) {
        int ans[] = new int[]{0};
        int t = helper(root, ans).maxSum;
        ans[0] = Math.max(ans[0], t);
        return ans[0];
    }
    
    private NodeValue helper(TreeNode root, int ans[]) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValue left = helper(root.left, ans);
        NodeValue right = helper(root.right, ans);
        
        ans[0] = Math.max(left.maxSum, Math.max(ans[0], right.maxSum));
        
        if (left.maxVal < root.val && root.val < right.minVal)
            return new NodeValue(Math.min(left.minVal, root.val), 
                                Math.max(right.maxVal, root.val), 
                                left.maxSum + root.val + right.maxSum);
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 
                            Math.max(left.maxSum, right.maxSum));
    }
}