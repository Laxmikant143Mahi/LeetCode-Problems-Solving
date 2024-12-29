class Solution {
    private int secondMinValue = -1; // Variable to store the second minimum value

    public int findSecondMinimumValue(TreeNode root) {
        // Start depth-first search with the root node's value as the initial value
        depthFirstSearch(root, root.val);
        // After DFS, return the second minimum value found
        return secondMinValue;
    }

    // Helper method to perform a depth-first search on the tree
    private void depthFirstSearch(TreeNode node, int firstMinValue) {
        // If the current node is not null, proceed with DFS
        if (node != null) {
            // Recursively traverse the left subtree
            depthFirstSearch(node.left, firstMinValue);
            // Recursively traverse the right subtree
            depthFirstSearch(node.right, firstMinValue);
            // Check if node's value is greater than first minimum value
            // and update the second minimum value accordingly
            if (node.val > firstMinValue) {
                // If secondMinValue hasn't been updated yet, use the current node's value
                // Else, update it to be the minimum of the current node's value and the existing secondMinValue
                secondMinValue = secondMinValue == -1 ? node.val : Math.min(secondMinValue, node.val);
            }
        }
    }
}