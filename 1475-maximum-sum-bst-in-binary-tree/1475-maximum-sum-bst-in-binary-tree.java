class Solution {
    static class BSTInfo {
        int min, max, sum, maxSum;

        BSTInfo(int min, int max, int sum, int maxSum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.maxSum = maxSum;
        }
    }

    private static BSTInfo findLargestBST(TreeNode root) {
        if (root == null) {
            return new BSTInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        }

        BSTInfo left = findLargestBST(root.left);
        BSTInfo right = findLargestBST(root.right);

        // Check if the current subtree satisfies BST properties
        if (left.max < root.val && right.min > root.val) {
            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);
            int sum = left.sum + right.sum + root.val;
            int maxSum = Math.max(sum, Math.max(left.maxSum, right.maxSum));
            return new BSTInfo(min, max, sum, maxSum);
        }

        // If the subtree is not a BST, propagate the maximum sum of BSTs found so far
        return new BSTInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, Math.max(left.maxSum, right.maxSum));
    }

    public static int maxSumBST(TreeNode root) {
        return findLargestBST(root).maxSum;
    }
}
