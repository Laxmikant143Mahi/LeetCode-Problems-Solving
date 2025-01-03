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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode temp = head;

        // Find the length of the list
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Move `left` to the kth node from the start
        for (int i = 1; i < k; i++) {
            left = left.next;
        }

        // Move `right` to the kth node from the end
        temp = head;
        for (int i = 1; i <= length - k; i++) {
            right = right.next;
        }

        // Swap the values of the two nodes
        int swapValue = left.val;
        left.val = right.val;
        right.val = swapValue;

        return head;
    }
}
