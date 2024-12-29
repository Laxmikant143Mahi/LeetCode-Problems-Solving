/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void dfs(TreeNode root, int k, boolean result[], HashSet<Integer> set){

        if(root==null){
            return;
        }
        if(set.contains(k-root.val)){
            result[0] = true;
            return;
        }

        set.add(root.val);

        dfs(root.left, k, result,set);
        
        dfs(root.right,k, result,set);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        boolean result[] = {false};
        dfs(root,k, result, set);

        return result[0];


    }
}