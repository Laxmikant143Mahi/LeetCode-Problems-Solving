class Solution {
    public ListNode doubleIt(ListNode head) {
        // Reverse the linked list for easier manipulation
        head = reverseList(head);

        ListNode dummy = new ListNode(0); // Dummy node to handle carry
        ListNode current = dummy;

        int carry = 0;
        while (head != null || carry > 0) {
            int sum = carry;
            if (head != null) {
                sum += head.val * 2; // Double the current digit
                head = head.next;
            }
            carry = sum / 10; // Calculate carry
            current.next = new ListNode(sum % 10); // Create a node for the current digit
            current = current.next;
        }

        // Reverse the result back to the original order
        return reverseList(dummy.next);
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
