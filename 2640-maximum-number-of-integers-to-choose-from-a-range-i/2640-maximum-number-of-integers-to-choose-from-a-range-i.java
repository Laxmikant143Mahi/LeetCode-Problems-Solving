class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet instead of HashMap for faster lookups
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        
        int sum = 0, count = 0;

        // Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip numbers that are in the banned set
            if (bannedSet.contains(i)) continue;

            // Check if adding the current number exceeds maxSum
            if (sum + i > maxSum) break;

            // Add the number to the sum and increment the count
            sum += i;
            count++;
        }
        
        return count;
    }
}
