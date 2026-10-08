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
        public void flatten(TreeNode root) {
        if(root == null) return;

        // TreeNode root = root;
        while(root != null) { 
            TreeNode left_side = root.left;

            if(root.left != null) {
                while(left_side.right != null) {
                    left_side = left_side.right;
                }
                left_side.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}