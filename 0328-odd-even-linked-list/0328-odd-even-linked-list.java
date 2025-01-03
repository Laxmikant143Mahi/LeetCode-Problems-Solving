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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head; // Handle edge cases with 0 or 1 nodes
        
        // Pointers for odd and even positions
        ListNode odd = head; 
        ListNode even = head.next;
        ListNode evenHead = even; // Save the head of even list to attach later
        
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Move odd pointer to the next odd node
            even.next = even.next.next; // Move even pointer to the next even node
            odd = odd.next; // Advance the odd pointer
            even = even.next; // Advance the even pointer
        }
        
        // Attach the even list to the end of the odd list
        odd.next = evenHead; 
        
        return head; // Return the modified head
    }
}
