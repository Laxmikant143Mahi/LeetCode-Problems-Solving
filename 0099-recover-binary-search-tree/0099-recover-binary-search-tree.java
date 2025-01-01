class Solution {
    public void recoverTree(TreeNode root) {
        // Step 1: Perform in-order traversal to collect node values
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        // Step 2: Identify the two swapped nodes
        int first = -1, second = -1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                if (first == -1) {
                    first = i;
                    second = i + 1;
                } else {
                    second = i + 1;
                }
            }
        }

        // The values of the two swapped nodes
        int val1 = list.get(first);
        int val2 = list.get(second);

        // Step 3: Traverse the tree again and correct the swapped nodes
        correctTree(root, val1, val2);
    }

    void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    void correctTree(TreeNode root, int val1, int val2) {
        if (root == null)
            return;

        if (root.val == val1) {
            root.val = val2;
        } else if (root.val == val2) {
            root.val = val1;
        }

        correctTree(root.left, val1, val2);
        correctTree(root.right, val1, val2);
    }
}
