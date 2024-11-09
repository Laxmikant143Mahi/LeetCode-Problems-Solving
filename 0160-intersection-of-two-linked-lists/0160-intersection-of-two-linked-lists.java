public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null; // If either list is empty, no intersection

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists
        while (pointerA != pointerB) {
            // If pointerA reaches the end, switch to headB
            pointerA = (pointerA != null) ? pointerA.next : headB;
            // If pointerB reaches the end, switch to headA
            pointerB = (pointerB != null) ? pointerB.next : headA;
        }

        return pointerA; // This will be the intersection node or null if no intersection
    }
}
