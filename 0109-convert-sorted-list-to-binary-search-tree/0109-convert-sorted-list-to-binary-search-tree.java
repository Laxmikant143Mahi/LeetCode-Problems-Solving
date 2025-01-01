
class Solution {
 
     TreeNode buildBST(ArrayList<Integer> tree, int start, int end){
        
        
        
        if(start > end){
            return null;
        }
        
        
        
        int mid = (start+end+1)/2;
        
        TreeNode root = new TreeNode(tree.get(mid));
        
        root.left = buildBST(tree, start, mid-1);
        
        root.right = buildBST(tree, mid+1, end);
        
        return root;
        
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        
        
        return buildBST(list, 0, list.size()-1);
    }
}

