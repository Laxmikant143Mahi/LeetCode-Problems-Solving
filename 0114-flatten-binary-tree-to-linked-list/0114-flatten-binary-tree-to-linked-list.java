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
        // Traverse the tree until we reach the end (null)
        while (root != null) {
            // If there is no left subtree, move to the right child
            if (root.left == null) {
                root = root.right;
            } else {
                // Find the rightmost node of the left subtree
                TreeNode curr = root.left;
                while (curr.right != null) {
                    curr = curr.right;
                }

                // Connect the right subtree to the rightmost node of the left subtree
                curr.right = root.right;
                
                // Move the left subtree to the right
                root.right = root.left;
                root.left = null;
                
                // Move to the right child for the next iteration
                root = root.right;
            }
        }
    }
}