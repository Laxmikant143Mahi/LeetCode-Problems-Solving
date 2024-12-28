class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                // Connect the previous node to the current node
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                // Add child nodes of the current node to the queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            // The last node in the level should point to null
            if (prev != null) {
                prev.next = null;
            }
        }

        return root;
    }
}
