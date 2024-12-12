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
    public ListNode swapPairs(ListNode head) {
        // If the list is empty or has only one node, return as is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        dummy.next = head;
        ListNode current = dummy;

        // Loop through the list and swap pairs
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap the pair
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;
    }
}
