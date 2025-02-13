import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildFinalString(s).equals(buildFinalString(t));
    }

    private String buildFinalString(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // Convert stack content to a string
        StringBuilder finalString = new StringBuilder();
        for (char c : stack) {
            finalString.append(c);
        }

        return finalString.toString();
    }
}
