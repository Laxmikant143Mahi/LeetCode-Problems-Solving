class Solution {
    private TreeNode curr; // Pointer to track the current node in the new tree
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        inOrder(root.left);
        
        // Process the current node
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        
        // Traverse the right subtree
        inOrder(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyRoot = new TreeNode(0); // Dummy node to start the new tree
        curr = dummyRoot; // Initialize pointer
        
        inOrder(root);
        
        return dummyRoot.right; // Return the actual start of the new tree
    }
}
