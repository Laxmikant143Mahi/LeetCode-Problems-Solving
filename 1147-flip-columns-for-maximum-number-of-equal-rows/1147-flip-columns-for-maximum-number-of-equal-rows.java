class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // HashMap to keep track of the frequency of each unique pattern
        Map<String, Integer> patternFrequency = new HashMap<>();
        // Variable to keep track of the max number of equal rows after flips
        int maxEqualRows = 0;
        // The number of columns in the matrix
        int columnCount = matrix[0].length;

        // Iterate over each row in the matrix
        for (int[] row : matrix) {
            // Create a character array to represent the pattern
            char[] patternChars = new char[columnCount];
            // Build the pattern based on the first element in the row
            for (int i = 0; i < columnCount; ++i) {
                // XOR the first element with each element in the row
                // If row[0] == row[i], the result will be 0; otherwise, it will be 1
                patternChars[i] = (char) ('0' + (row[0] ^ row[i]));
            }
            // Convert the character array to a string representing the pattern
            String pattern = String.valueOf(patternChars);
            // Update the pattern frequency map with the new pattern, 
            // incrementing the count of the pattern by 1
            int patternCount = patternFrequency.merge(pattern, 1, Integer::sum);
            // Update maxEqualRows if the current pattern count is greater
            maxEqualRows = Math.max(maxEqualRows, patternCount);
        }

        // Return the maximum number of equal rows that can be obtained after flips
        return maxEqualRows;
    }
}
