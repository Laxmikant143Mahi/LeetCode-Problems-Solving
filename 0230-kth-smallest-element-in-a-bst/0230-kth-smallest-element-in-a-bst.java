class Solution {

    // Helper method to perform in-order traversal and find kth smallest
    void findK(TreeNode root, int[] k, int[] element) {
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        findK(root.left, k, element);
        
        // Decrease k before checking the condition, to ensure we reach the kth smallest element
        k[0]--;
        
        // If k is zero, we have found the kth smallest element
        if (k[0] == 0) {
            element[0] = root.val;
            return;
        }
        
        // Traverse the right subtree
        findK(root.right, k, element);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] kWrapper = {k};  // Use an array to hold k
        int[] element = {0};    // Array to store the result
        
        findK(root, kWrapper, element);  // Call the helper function
        
        return element[0];  // Return the kth smallest element
    }
}
