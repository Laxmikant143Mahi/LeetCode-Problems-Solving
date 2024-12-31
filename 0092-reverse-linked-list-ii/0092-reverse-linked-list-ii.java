class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: If the list is empty or no reversal is needed
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge cases like reversing from the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to the node just before the `left` position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // `curr` points to the node at the `left` position
        ListNode curr = prev.next;
        ListNode next = null;

        // Reverse the sublist from `left` to `right`
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        // Return the modified list
        return dummy.next;
    }
}
