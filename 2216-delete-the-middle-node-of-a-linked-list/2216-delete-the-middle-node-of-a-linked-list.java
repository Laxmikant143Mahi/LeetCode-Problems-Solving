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
    public ListNode deleteMiddle(ListNode head) {
        // Check if the list has only one node. In that case, return null as there is no middle node.
        if(head.next == null) return null;
        
        // Initialize two pointers:
        // trvEnd will move two steps at a time, and mid will move one step at a time.
        ListNode trvEnd = head.next.next; // trvEnd starts from the node after the second node.
        ListNode mid = head; // mid starts from the head of the list.

        // Loop through the list. We stop when trvEnd reaches the end (null or null.next).
        while(trvEnd != null && trvEnd.next != null){
            // Move trvEnd two steps forward.
            trvEnd = trvEnd.next.next;
            
            // Move mid one step forward.
            mid = mid.next;
        }

        // At this point, mid is pointing to the node just before the middle node.
        // Remove the middle node by adjusting the next pointer of the node before it.
        mid.next = mid.next.next;

        // Return the modified list with the middle node deleted.
        return head;
    }
}
