import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Remove the closest non-digit if the stack isn't empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push non-digit characters onto the stack
                stack.push(c);
            }
        }

        // Build the resulting string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
