import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the input is empty
        if (lists == null || lists.length == 0) return null;

        // Priority Queue to store nodes in ascending order
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-null list to the priority queue
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0); // Dummy node to form the result list
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;

            if (smallestNode.next != null) {
                pq.offer(smallestNode.next);
            }
        }

        return dummy.next;
    }
}
