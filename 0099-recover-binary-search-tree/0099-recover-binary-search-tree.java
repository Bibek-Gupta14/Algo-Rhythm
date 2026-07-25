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
    TreeNode prev;
    TreeNode first;
    TreeNode last;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && (root.val < prev.val)) {

            //first violation - adjacent element
            if (first == null) {
                first = prev;
            }

            // second violantion - different location
            last = root;
        } 
        prev = root;
        inorder(root.right);

    }
    public void recoverTree(TreeNode root) {
        first = null;
        last = null;
        prev = null;
        inorder(root);

        //first violation
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } 
    }
}