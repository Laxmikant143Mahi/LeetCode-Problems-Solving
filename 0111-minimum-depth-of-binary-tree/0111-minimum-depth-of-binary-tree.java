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
    public int findMinDepth(TreeNode root) {
        if (root == null)
            return 0;

        // If left is null, go right only
        if (root.left == null)
            return 1 + findMinDepth(root.right);

        // If right is null, go left only
        if (root.right == null)
            return 1 + findMinDepth(root.left);

        // Both children exist — choose min of both
        return 1 + Math.min(findMinDepth(root.left), findMinDepth(root.right));
    }


    public int minDepth(TreeNode root) {
        
        return findMinDepth(root);

        
    }
}