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

    // Helper method to perform in-order traversal and collect elements in a list
    void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Perform in-order traversal on both trees
        inOrder(root1, list1);
        inOrder(root2, list2);

        int first = 0, second = 0;
        List<Integer> ans = new ArrayList<>();

        // Merge the two sorted lists
        while (first < list1.size() && second < list2.size()) {
            if (list1.get(first) <= list2.get(second)) {
                ans.add(list1.get(first));
                first++;
            } else {
                ans.add(list2.get(second));
                second++;
            }
        }

        // Add remaining elements from list1, if any
        while (first < list1.size()) {
            ans.add(list1.get(first));
            first++;
        }

        // Add remaining elements from list2, if any
        while (second < list2.size()) {
            ans.add(list2.get(second));
            second++;
        }

        return ans;
    }
}
