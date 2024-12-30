class Solution {
    public TreeNode BST(int[] preorder, int[] index, int lower, int upper) {
        if (index[0] == preorder.length || preorder[index[0]] < lower || preorder[index[0]] > upper) {
            return null;
        }

        int val = preorder[index[0]++];
        TreeNode root = new TreeNode(val);

        root.left = BST(preorder, index, lower, val);  // Left subtree
        root.right = BST(preorder, index, val, upper); // Right subtree

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0}; // Using an array to mimic pass-by-reference for index
        return BST(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
