class Solution {

    // Helper method to collect leaf nodes iteratively
    private void collectLeafNodes(TreeNode node, ArrayList<Integer> leafList) {
        if (node == null) {
            return;
        }

        // If it's a leaf node (no children), add it to the list
        if (node.left == null && node.right == null) {
            leafList.add(node.val);
            return;
        }

        // Traverse the left and right children
        collectLeafNodes(node.left, leafList);
        collectLeafNodes(node.right, leafList);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Create two lists to hold the leaf nodes of each tree
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Collect leaf nodes for both trees
        collectLeafNodes(root1, list1);
        collectLeafNodes(root2, list2);

        // If the sizes of the lists are different, return false
        if (list1.size() != list2.size()) {
            return false;
        }

        return list1.equals(list2);
    }
}
