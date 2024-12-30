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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);


        while(!queue.isEmpty()){

            int size = queue.size();
            double avg = 0;
            for(int i=1; i<=size; i++){

                TreeNode temp = queue.poll();

                avg+=temp.val;
                if(temp.left!=null)
                    queue.add(temp.left);

                if(temp.right!=null)
                    queue.add(temp.right);
            }

            avg/=size;
            list.add(avg);
        }

        return list;
    }
}