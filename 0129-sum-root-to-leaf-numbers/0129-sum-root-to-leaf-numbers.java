class Solution {
    // This method starts the process of summing up all the numbers formed by the root-to-leaf paths.
    public int sumNumbers(TreeNode root) {
        return depthFirstSearch(root, 0);
    }

    // Helper method to perform depth-first search on the tree.
    // It accumulates the values from the root to each leaf, forming the numbers.
    private int depthFirstSearch(TreeNode node, int sum) {
        // If the current node is null, return 0 as there are no numbers to form here.
        if (node == null) {
            return 0;
        }

        // Update the current sum by appending the current node value.
        sum = sum * 10 + node.val;

        // If we reached a leaf, return the sum as we completed the formation of one number.
        if (node.left == null && node.right == null) {
            return sum;
        }

        // Continue the DFS traversal by visiting the left and right subtrees and summing the numbers formed.
        return depthFirstSearch(node.left, sum) + depthFirstSearch(node.right, sum);
    }
}
