import java.util.Stack;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            // Make current node the right child of nodes smaller than it
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // Make the top of the stack the parent of the current node
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            // Push the current node onto the stack
            stack.push(current);
        }

        // The root is the bottom-most element in the stack
        return stack.firstElement();
    }
}
