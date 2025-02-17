class Solution {
    // Method to calculate the number of possible permutations of the tiles
    public int numTilePossibilities(String tiles) {
        // Array to hold the count of each uppercase letter from A to Z
        int[] count = new int[26];
        // Increment the respective array position for each character in tiles string
        for (char tile : tiles.toCharArray()) {
            count[tile - 'A']++;
        }
        // Start the recursive Depth-First Search (DFS) to calculate permutations
        return dfs(count);
    }

    // Recursive Depth-First Search method to calculate possible permutations
    private int dfs(int[] count) {
        int sum = 0; // Initialize sum to hold number of permutations
        // Iterate over the count array
        for (int i = 0; i < count.length; i++) {
            // If count of a particular character is positive, process it
            if (count[i] > 0) {
                // Increase the sum as we have found a valid character
                sum++;
                // Decrease the count for that character as it is being used
                count[i]--;
                // Further deep dive into DFS with reduced count
                sum += dfs(count);
                // Once DFS is back from recursion, revert the count used for the character
                count[i]++;
            }
        }
        // Return the sum of permutations
        return sum;
    }
}