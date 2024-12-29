class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // Call the helper function with the entire array
        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] nums, int start, int end) {
        // Base case: if start exceeds end, return null
        if (start > end) {
            return null;
        }

        // Find the middle element
        int mid =(start+end)>>1;

        // Create a new TreeNode with the middle element
        TreeNode temp = new TreeNode(nums[mid]);

        // Recursively construct the left and right subtrees
        temp.left = create(nums, start, mid - 1);
        temp.right = create(nums, mid + 1, end);

        // Return the constructed subtree
        return temp;
    }
}
