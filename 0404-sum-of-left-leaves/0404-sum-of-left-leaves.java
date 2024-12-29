class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, return 0
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if the left child is a leaf
            if (current.left != null && current.left.left == null && current.left.right == null) {
                sum += current.left.val; // Add the value of the left leaf to the sum
            }

            // Add left and right children to the queue for traversal
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return sum; // Return the total sum of left leaves
    }
}
