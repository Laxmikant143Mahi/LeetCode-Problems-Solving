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

    public void inOrder(ArrayList<Integer> list, TreeNode root){

        if(root == null){
            return;
        }

        inOrder(list,root.left);

        list.add(root.val);

        inOrder(list,root.right);
    }

    public int minDiffInBST(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<>();

        inOrder(list, root);

        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++){

            minDiff = Math.min(minDiff, Math.abs(list.get(i) - list.get(i+1)) );
        }

        return minDiff;
    }
}