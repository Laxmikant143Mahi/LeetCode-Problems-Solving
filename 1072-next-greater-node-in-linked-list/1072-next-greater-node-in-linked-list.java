class Solution {

    // Method to find the next larger node values for each node in the linked list
    public int[] nextLargerNodes(ListNode head) {
        // Use an ArrayList to store the values of the nodes for easier access
        List<Integer> nodeValues = new ArrayList<>();
        // Traverse the linked list and add values to the list
        while (head != null) {
            nodeValues.add(head.val);
            head = head.next;
        }

        // Use a Deque as a stack to keep track of next larger element we have seen so far
        Deque<Integer> stack = new ArrayDeque<>();
        // Find the size of the linked list
        int listSize = nodeValues.size();
        // Create an array to store the result
        int[] result = new int[listSize];
      
        // Traverse the list in reverse using the values ArrayList
        for (int i = listSize - 1; i >= 0; --i) {
            // Pop elements from the stack if they are less than or equal
            // to the current node's value, since we are only interested
            // in the next greater value
            while (!stack.isEmpty() && stack.peek() <= nodeValues.get(i)) {
                stack.pop();
            }
            // If the stack is not empty after popping, the current value at the top
            // is the next greater value, so we add it to the result
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            // Push the current node's value onto stack
            stack.push(nodeValues.get(i));
        }
        // Return the populated result array containing next larger values
        return result;
    }
}