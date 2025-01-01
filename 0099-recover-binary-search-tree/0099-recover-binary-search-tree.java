class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode current = root, first = null, second = null, last = null, prev = null;

        while (current != null) {
            if (current.left == null) {
                // Process the current node
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = current;
                }
                prev = current;

                // Move to the right
                current = current.right;
            } else {
                // Find the predecessor
                TreeNode pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Create a temporary thread to the current node
                    pred.right = current;
                    current = current.left;
                } else {
                    // Remove the temporary thread and process the current node
                    pred.right = null;
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = current;
                    }
                    prev = current;

                    // Move to the right
                    current = current.right;
                }
            }
        }

        // Swap the values of the two nodes to fix the BST
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
