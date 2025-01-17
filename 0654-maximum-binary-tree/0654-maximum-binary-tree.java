import java.util.Stack;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();

        for (int num : nums) {
            // Create a TreeNode for the current number
            TreeNode current = new TreeNode(num);

            // Step 1: Find the left child (pop smaller elements)
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // Step 2: The top of the stack (if it exists) is the parent
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            // Step 3: Push the current node into the stack
            stack.push(current);
        }

        // Step 4: The bottom-most node in the stack is the root of the tree
        return stack.firstElement();
    }
}
