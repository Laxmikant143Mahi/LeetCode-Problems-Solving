class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list; // Handle null root case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> minList = new ArrayList<>();

            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.poll();
                minList.add(temp.val);

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }

            list.add(0, minList); // Add the level at the beginning for bottom-up order
        }

        return list;
    }
}
