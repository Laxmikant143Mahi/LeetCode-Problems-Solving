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
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
            return root;
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
            return root;
        } else {
            // Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 Child Present
            else if (root.left == null && root.right != null) { // Only right child exists
                return root.right;
            } else if (root.left != null && root.right == null) { // Only left child exists
                return root.left;
            } else {
                // Both children exist
                // Find the greatest element from left
                TreeNode child = root.left;
                TreeNode parent = root;

                // Traverse to the rightmost node
                while (child.right != null) {
                    parent = child;
                    child = child.right;
                }

                // Replace root with child
                if (root != parent) {
                    parent.right = child.left;
                    child.left = root.left;
                    child.right = root.right;
                } else {
                    child.right = root.right;
                }

                // Return the replacement node
                return child;
            }
        }
    }
}
