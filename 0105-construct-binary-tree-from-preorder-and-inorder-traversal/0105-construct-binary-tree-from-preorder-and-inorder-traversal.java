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
    int index = 0;
    HashMap<Integer, Integer> map;
    public TreeNode solve(int[] preorder, int start, int end) {
        if(start > end) return null;

        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        root.left = solve(preorder, start, mid-1);
        root.right = solve(preorder, mid+1, end);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;
    
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return solve(preorder, 0, n-1);
    }
}