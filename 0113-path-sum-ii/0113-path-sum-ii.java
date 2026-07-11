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

    public void AllPath(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if(root == null) return;
        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(path));
        }
        AllPath(root.left, targetSum-root.val, path, ans);
        AllPath(root.right, targetSum-root.val, path, ans);

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        AllPath(root, targetSum, path, ans);

        return ans;
    }
}