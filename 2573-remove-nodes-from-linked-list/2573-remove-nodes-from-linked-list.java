/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        // Traverse the list and use the stack to maintain the order
        while (temp != null) {
            // Remove nodes from the stack that are smaller than the current node
            while (!stack.isEmpty() && stack.peek().val < temp.val) {
                stack.pop();
            }
            stack.push(temp);
            temp = temp.next;
        }

        // Reconstruct the linked list from the stack
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            stack.peek().next = newHead;
            newHead = stack.pop();
        }

        return newHead;
    }
}
