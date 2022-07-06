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
        Stack<Node> st = new Stack<>();
        while (true) {
            if (root != null) {
                st.push(new Node(root, 1));
                root = root.left;
            } else {
                if (st.isEmpty())
                    break;
                if (st.peek().visCount == 1) {
                    ++st.peek().visCount;
                    root = st.peek().node.right;
                } else {
                    ans.add(st.pop().node.val);
                    root = null;
                }
            }
        }
        return ans;
    }
}

class Node {
    TreeNode node;
    int visCount;
    Node (TreeNode node, int cnt) {
        this.node = node;
        this.visCount = cnt;
    }
}
