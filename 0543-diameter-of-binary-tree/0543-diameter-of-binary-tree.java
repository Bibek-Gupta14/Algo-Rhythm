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
    int max = 0;

    public int heightofBT(TreeNode root) {
        if (root == null) return 0;

        int lh = heightofBT(root.left);
        int rh = heightofBT(root.right);
        max = Math.max(lh+rh, max); 
            
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        heightofBT(root);

        return max;
    }
}