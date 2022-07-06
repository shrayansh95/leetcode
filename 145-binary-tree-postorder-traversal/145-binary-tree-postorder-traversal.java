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
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp;
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                if(st.isEmpty())
                    break;
                temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    ans.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                } else {
                    root = temp;
                }
            }
        }
        return ans;
    }
}

