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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy head to simplify edge cases such as removing the first element
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // Initialize the previous node as the dummy node
        ListNode previousNode = dummyHead;
      
        // Iterate through the list
        while (previousNode.next != null) {
            // Check if the current node has the value we need to remove
            if (previousNode.next.val == val) {
                // Remove the current node from the list
                previousNode.next = previousNode.next.next;
            } else {
                // Move to the next node
                previousNode = previousNode.next;
            }
        }
      
        // Return the new head of the list, which is the next of dummy node 
        return dummyHead.next;
    }
}
