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

    boolean isSymmetry(TreeNode root1, TreeNode root2){
      if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if(root1.val!=root2.val)
            return false;
        
    

       return root1.val == root2.val && 
       isSymmetry(root1.left, root2.right) && 
       isSymmetry(root1.right, root2.left);

        }

       
    
    public boolean isSymmetric(TreeNode root) {
        

        return isSymmetry(root.left, root.right);

        // Queue<TreeNode> queue = new LinkedList<>();

        // queue.add(root);

        // while(queue.isEmpty()){

        //     ArrayList<Integer> list = new ArrayList<>();
        //     int size = queue.size();


        //     for(int i=0; i<size; i++){
                
        //      TreeNode temp = queue.poll();
        //      list.add(temp.val);

        //      if(temp.left!=null)
        //         queue.add(temp.left);
        //      if(temp.right!=null)
        //         queue.add(temp.right);

        //     }

        //     int start=0, end = list.size()-1;

        //     while(start<=end){

        //         if(list.get(start) != list.get(end)){

        //              return false;
                     
        //         }
        //         start++;
        //              end--;
                   
        //     }
        //     list.clear();


        // }

        // return true;
    }
}