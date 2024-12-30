/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         // If root is null, there is no LCA.
        if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, LCA lies in the left subtree.
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        // If both n1 and n2 are greater than root, LCA lies in the right subtree.
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        // If root splits n1 and n2, it is their LCA.
        else 
            return root;
    }
}