class Solution {
  
    /**
     * This method calculates the minimum number of characters to remove from the string so that each character
     * appears at least 'k' times in the remaining string.
     *
     * @param s The input string.
     * @param k The minimum number of times each character should appear.
     * @return The minimum number of characters to remove, or -1 if it's not possible.
     */
    public int takeCharacters(String s, int k) {
        int[] charCounts = new int[3]; // Array to store the count of each character 'a', 'b', and 'c'.
        int length = s.length(); // The length of the input string.

        // Count occurrences of each character ('a', 'b', 'c').
        for (int i = 0; i < length; ++i) {
            // Increment the count for the current character.
            charCounts[s.charAt(i) - 'a']++;
        }

        // Check if any character appears less than 'k' times.
        for (int count : charCounts) {
            if (count < k) {
                return -1; // It's not possible to fulfill the condition.
            }
        }

        int maxSubstringLength = 0; // Will hold the length of the longest valid substring.
        int leftPointer = 0; // Points to the start of the current substring.

        // Iterate over the characters of the string.
        for (int rightPointer = 0; rightPointer < length; ++rightPointer) {
            int currentCharIndex = s.charAt(rightPointer) - 'a'; // Index of the current character.
            // Decrement the count of the current character since we're moving rightPointer.
            charCounts[currentCharIndex]--;
          
            // If count of the current character falls below 'k', readjust the leftPointer.
            while (charCounts[currentCharIndex] < k) {
                // Increment count of the character at leftPointer as it's no longer in current substring.
                charCounts[s.charAt(leftPointer) - 'a']++;
                // Move leftPointer to the right.
                leftPointer++;
            }

            // Update the length of the longest valid substring found so far.
            maxSubstringLength = Math.max(maxSubstringLength, rightPointer - leftPointer + 1);
        }

        // Return the minimum number of characters to remove, i.e., total length minus length of longest valid substring.
        return length - maxSubstringLength;
    }
}