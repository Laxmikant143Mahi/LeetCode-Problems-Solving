class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If root is null or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right)
        return left != null ? left : right;
    }
}
