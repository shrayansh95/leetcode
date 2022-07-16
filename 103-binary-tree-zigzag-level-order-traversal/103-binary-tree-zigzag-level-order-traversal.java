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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        
        if (root == null)
            return levelOrder;
        
        // Flag to check from where does we need to add elements
        // For the next level 
        boolean startFromLeft = true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        TreeNode temp;
        int size;
        
        while (!q.isEmpty()) {
            size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                temp = q.poll();
                if (startFromLeft)
                    level.add(temp.val);
                else
                    level.add(0, temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            levelOrder.add(level);
            startFromLeft = !startFromLeft;
        }
        return levelOrder;
    }
}