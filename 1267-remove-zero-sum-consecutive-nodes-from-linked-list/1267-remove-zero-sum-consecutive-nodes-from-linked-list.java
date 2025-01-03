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
    public ListNode removeZeroSumSublists(ListNode head) {
        // Create a dummy node to handle edge cases where the head is part of a zero-sum sublist
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use a HashMap to store the cumulative sum and the corresponding node
        Map<Integer, ListNode> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        // First pass: Calculate cumulative sum and populate the map
        ListNode current = dummy;
        while (current != null) {
            cumulativeSum += current.val;
            sumMap.put(cumulativeSum, current);
            current = current.next;
        }

        // Second pass: Remove nodes part of zero-sum sublists
        cumulativeSum = 0;
        current = dummy;
        while (current != null) {
            cumulativeSum += current.val;
            // If a cumulative sum is found again, it means the nodes in between sum to zero
            current.next = sumMap.get(cumulativeSum).next;
            current = current.next;
        }

        return dummy.next;
    }
}
