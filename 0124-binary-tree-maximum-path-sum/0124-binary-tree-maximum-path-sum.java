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
    int max = Integer.MIN_VALUE; // global variable

    public int checkMaxPath(TreeNode root) {
        if (root == null)
            return 0;
        // max = Integer.MIN_VALUE;
        int left = Math.max(0, checkMaxPath(root.left));
        int right = Math.max(0, checkMaxPath(root.right));

        max = Math.max(max, (root.val + left + right));     // calculate the max sum at that node

        return root.val + Math.max(left, right);    // recursively bactrack and return width of a BT
    }

    public int maxPathSum(TreeNode root) {
        // int max = Integer.MIN_VALUE;
        checkMaxPath(root);

        return max;
    }
}