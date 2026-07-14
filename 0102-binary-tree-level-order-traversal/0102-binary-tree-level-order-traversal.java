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
//  */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();       //final nested list
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();     // BFS uses Queue DS
        q.add(root);    // add the val to queue to check

        while (!q.isEmpty()) {
            int length = q.size();      // length of the 1D list individually
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                TreeNode node = q.poll();       // poll() -> same as pop() in stack
                level.add(node.val);    // add it to the level after done

                if (node.left != null) {    //recursively traverse the indivdual node's left 
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);     // add the individual 1D list (level) -> main ans (2D list)
        }
        return ans;
    }
}