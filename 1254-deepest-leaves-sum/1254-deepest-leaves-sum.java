class Solution {
    /**
     * Computes the sum of the deepest leaves in the binary tree.
     *
     * @param root the root node of the binary tree.
     * @return the sum of the deepest leaves.
     */
    public int deepestLeavesSum(TreeNode root) {
        // Initialize a queue to perform level-order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
      
        // Variable to store the sum of the values of the deepest leaves
        int sum = 0;

        // Perform level-order traversal of the tree
        while (!queue.isEmpty()) {
            sum = 0; // Reset sum for the current level
            // Process all nodes at the current level
            for (int size = queue.size(); size > 0; --size) {
                TreeNode currentNode = queue.pollFirst();
                // Add the value of the current node to the sum
                sum += currentNode.val;
                // If the left child exists, add it to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // If the right child exists, add it to the queue for the next level
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // The loop goes back to process the next level, if any
        }
        // After the loop, sum contains the sum of the deepest leaves
        return sum;
    }
}
