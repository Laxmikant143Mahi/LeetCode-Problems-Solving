class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // Initialize a queue to perform level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Use add() to add the root node
      
        // Variable to store the sum of the values of the deepest leaves
        int sum = 0;

        // Perform level-order traversal of the tree
        while (!queue.isEmpty()) {
            sum = 0; // Reset sum for the current level
            // Process all nodes at the current level
            for (int size = queue.size(); size > 0; --size) {
                TreeNode currentNode = queue.poll(); // Use poll() to remove elements from the queue
                // Add the value of the current node to the sum
                sum += currentNode.val;
                // If the left child exists, add it to the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left); // Use add() instead of offer()
                }
                // If the right child exists, add it to the queue for the next level
                if (currentNode.right != null) {
                    queue.add(currentNode.right); // Use add() instead of offer()
                }
            }
        }
        // After the loop, sum contains the sum of the deepest leaves
        return sum;
    }
}
