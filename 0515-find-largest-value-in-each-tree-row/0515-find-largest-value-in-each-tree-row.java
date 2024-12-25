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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root==null) return new ArrayList<>();

        int maxElement = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level =0;
        ArrayList<Integer> list = new ArrayList<>();


        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                maxElement = Math.max(maxElement, temp.val);

                if(temp.left!=null){
                    queue.add(temp.left);
                }

                if(temp.right!=null){
                    queue.add(temp.right);
                }

            }

            list.add(maxElement);
            maxElement = Integer.MIN_VALUE;
           


        }

        return list;
    }
}