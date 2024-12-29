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

    public void dfs(TreeNode root, HashMap<Integer,Integer> map){

        if(root==null){
            return;
        }


        map.put(root.val, map.getOrDefault(root.val,0)+1);
        dfs(root.left, map);
        dfs(root.right,map);

    }
    public int[] findMode(TreeNode root) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        dfs(root,map);
        int maxCount = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                maxCount = Math.max(maxCount, entry.getValue());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            if(entry.getValue() == maxCount){
                list.add(entry.getKey());
            }
        }

        int ans[] = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;


    }
}