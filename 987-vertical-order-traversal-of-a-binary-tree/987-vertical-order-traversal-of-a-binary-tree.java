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
import java.util.SortedMap;
class Tuple {
    TreeNode node;
    int row, col;
    Tuple(TreeNode _node, int _row, int _col) {
        this.node = _node;
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        SortedMap<Integer, SortedMap<Integer, PriorityQueue<Integer>>> map = 
            new TreeMap<>();
        q.add(new Tuple(root, 0, 0));
        Tuple tuple;
        TreeNode node;
        int ver, lev;
        
        while (!q.isEmpty()) {
            tuple = q.poll();
            node = tuple.node;
            ver =  tuple.col;
            lev = tuple.row;
            
            if (!map.containsKey(ver))
                map.put(ver, new TreeMap<>());
            
            if (!map.get(ver).containsKey(lev)) 
                map.get(ver).put(lev, new PriorityQueue<>());
            
            map.get(ver).get(lev).add(node.val);
            
            if (node.left != null)
                q.add(new Tuple(node.left, lev + 1, ver - 1));
            
            if (node.right != null)
                q.add(new Tuple(node.right, lev + 1, ver + 1));
        }
        
        for (SortedMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) 
                    ans.get(ans.size() - 1).add(nodes.poll());
            }
        }
        return ans;
    }
}