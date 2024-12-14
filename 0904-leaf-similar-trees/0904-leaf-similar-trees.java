class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList<>();
    List<Integer> leaves2 = new ArrayList<>();

    // Perform DFS for both trees to collect leaf values
    dfs(root1, leaves1);
    dfs(root2, leaves2);

    // Compare the leaf values of both trees
    return leaves1.equals(leaves2);
  }

  // Helper DFS function to collect leaf nodes
  public void dfs(TreeNode node, List<Integer> leaves) {
    if (node == null) return;

    // If it's a leaf node, add its value to the list
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return;
    }

    // Recursively traverse the left and right subtrees
    dfs(node.left, leaves);
    dfs(node.right, leaves);
  }
}
