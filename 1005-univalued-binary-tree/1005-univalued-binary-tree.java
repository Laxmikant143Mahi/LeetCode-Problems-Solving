class Solution {
    // Public method to check if a tree is a univalued tree
    public boolean isUnivalTree(TreeNode root) {
        // If the root is null, the tree is trivially univalued
        if (root == null) {
            return true;
        }
        // Use depth-first search starting with the root value to check univalued property
        return dfs(root, root.val);
    }

    // Private helper method to perform depth-first search on tree nodes
    private boolean dfs(TreeNode node, int val) {
        // If the current node is null, we've reached the end of a branch - return true
        if (node == null) {
            return true;
        }
        // Check if the current node value is equal to the given value
        // and recursively check both the left and right subtrees
        return node.val == val && dfs(node.left, val) && dfs(node.right, val);
    }
}