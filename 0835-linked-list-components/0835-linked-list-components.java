class Solution {
    public int numComponents(ListNode head, int[] nums) {
        // Create a set to store the values in nums for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int count = 0;
        boolean inComponent = false;

        // Traverse the linked list
        while (head != null) {
            if (set.contains(head.val)) {
                // Start or continue a component
                if (!inComponent) {
                    count++;
                    inComponent = true;
                }
            } else {
                // End the current component
                inComponent = false;
            }
            head = head.next;
        }
        
        return count;
    }
}
