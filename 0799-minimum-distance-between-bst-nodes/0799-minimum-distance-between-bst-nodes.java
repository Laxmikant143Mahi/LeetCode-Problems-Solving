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
    private Integer prev = null;  // To store the previous node's value during in-order traversal
    private int minDiff = Integer.MAX_VALUE;  // To store the minimum difference

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inOrder(root.left);

        // If prev is not null, calculate the difference between the current and previous node
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        // Update prev to the current node's value
        prev = root.val;

        // Traverse the right subtree
        inOrder(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inOrder(root);  // Perform in-order traversal and calculate minimum difference
        return minDiff; // Return the minimum difference found
    }
}
