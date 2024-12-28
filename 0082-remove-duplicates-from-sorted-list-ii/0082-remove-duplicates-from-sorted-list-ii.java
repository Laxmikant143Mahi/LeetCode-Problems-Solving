class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases cleanly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            // Check for duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all duplicate nodes
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after the duplicates
                prev.next = head.next;
            } else {
                // Move prev only if current node is not a duplicate
                prev = prev.next;
            }
            // Move to the next node
            head = head.next;
        }

        return dummy.next;
    }
}
