
class Solution {
    public void inOrder(TreeNode root, int low, int high, int sum[]){

        if(root==null)
            return;

        inOrder(root.left, low, high, sum);
        
        if(root.val>=low && root.val<=high)
            sum[0]+=root.val;
        
        inOrder(root.right, low, high, sum);
        

    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        int sum[] = {0};

        inOrder(root,low,high,sum);

        return sum[0];
    }
}