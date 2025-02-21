import java.util.HashSet;
import java.util.Set;

// Reconstructed tree where every node's value equals twice the value of their
// parent (left child) or twice the value plus one (right child), as if it were
// a binary heap, starting with 0 as the root's value.
class FindElements {
    // Store the values of all the nodes after "recovering" the tree
    private Set<Integer> recoveredValues = new HashSet<>();

    // Constructor that starts the recovery process of the given tree
    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val = 0; // The recovery process starts by setting the root's value to 0
        recoverTree(root);
    }

    // Helper method to recover the tree
    private void recoverTree(TreeNode node) {
        if (node == null) {
            return;
        }
        recoveredValues.add(node.val); // Add the current node's value to the set
        // Recursively recover the left subtree, if it exists, by setting the left child's value
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            recoverTree(node.left);
        }
        // Recursively recover the right subtree, if it exists, by setting the right child's value
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recoverTree(node.right);
        }
    }

    // Check if a target value exists in the recovered tree
    public boolean find(int target) {
        return recoveredValues.contains(target);
    }
}
