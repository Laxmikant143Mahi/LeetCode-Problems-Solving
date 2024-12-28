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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each value in the list
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        // Use a dummy node to handle edge cases cleanly
        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        ListNode prev = dummy;
        temp = head;

        while (temp != null) {
            if (map.get(temp.val) > 1) {
                // Skip the node with duplicates
                prev.next = temp.next;
            } else {
                // Move the prev pointer forward only if the node is not skipped
                prev = temp;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}
