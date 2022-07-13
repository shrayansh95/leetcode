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
class Pair {
    TreeNode node;
    int idx;
    public Pair(TreeNode _node, int _idx) {
        this.node = _node;
        this.idx = _idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0, first = 0, last = 0, size = 0, min;
        q.add(new Pair(root, 0));
        TreeNode temp;
        Pair pair;
        int idx = 0;
        while (!q.isEmpty()) {
            size = q.size();
            first = 0;
            last = 0;
            min = q.peek().idx;
            for (int i = 0; i < size; ++i) {
                pair = q.poll();
                temp = pair.node;
                idx = pair.idx - min;
                if (i == 0)
                    first = idx;
                else if (i == size - 1)
                    last = idx;
                if (temp.left != null)
                    q.add(new Pair(temp.left, 2 * idx + 1));
                if (temp.right != null)
                    q.add(new Pair(temp.right, 2 * idx + 2));
            }
            maxWidth = Math.max(maxWidth, (last - first + 1));
        }
        return maxWidth;
    }
}