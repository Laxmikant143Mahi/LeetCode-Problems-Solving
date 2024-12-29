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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null; // Base case: if the tree is empty, return null
        }

        // Recursively remove leaf nodes from the left and right subtrees
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // If the current node is a leaf and its value equals the target, remove it
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        // Return the current node
        return root;
    }
}
