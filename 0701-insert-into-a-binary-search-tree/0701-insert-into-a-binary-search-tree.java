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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root; // we took a copy of the root, as we have to return the root at the end

        while (true) {
            if (val > temp.val) {
                //go to right subtree
                if (temp.right != null)
                    temp = temp.right;
                else {
                    temp.right = new TreeNode(val);
                    break; // done
                }
            } else {
                if (temp.left != null)
                    temp = temp.left; // recursion
                else {
                    temp.left = new TreeNode(val);
                    break; // done
                }
            }
        }
        return root;
    }
}