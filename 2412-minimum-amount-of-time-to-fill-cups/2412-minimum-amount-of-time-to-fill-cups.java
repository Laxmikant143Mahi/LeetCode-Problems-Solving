class Solution {
    public int fillCups(int[] amount) {
        int total = amount[0] + amount[1] + amount[2];
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        
        // Minimum time is the maximum of:
        // 1. The largest single element (dominates the time if others are small)
        // 2. The sum of all elements divided by 2 (since two cups can be filled simultaneously)
        return Math.max(max, (total + 1) / 2);
    }
}
