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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true; // An empty tree is valid
        }

        if (lower != null && node.val <= lower) {
            return false; // Node value must be greater than the lower bound
        }
        if (upper != null && node.val >= upper) {
            return false; // Node value must be less than the upper bound
        }

        // Recursively validate the left and right subtrees
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
