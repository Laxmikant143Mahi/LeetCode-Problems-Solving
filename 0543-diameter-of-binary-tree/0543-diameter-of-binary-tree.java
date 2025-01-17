class Solution {
    private int diameter = 0;

    // Helper function to compute the height of the tree and update the diameter
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Get the heights of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update the diameter: longest path through the root
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the tree rooted at the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Compute the height and update the diameter
        height(root);
        return diameter;
    }
}