class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Initialize the start and end pointers for binary search
        int start = 0;
        int end = letters.length;
      
        // Perform binary search to find the smallest letter greater than target
        while (start < end) {
            // Calculate the mid point to split the search into halves
            int mid = (start + end) >>> 1; // Using unsigned shift for safe mid calculation
          
            // If the middle letter is greater than the target
            if (letters[mid] > target) {
                // We have a new possible candidate for next greatest letter (inclusive)
                // and we need to search to the left of mid (exclusive)
                end = mid;
            } else {
                // If mid letter is less than or equal to the target,
                // we need to search to the right of mid (exclusive)
                start = mid + 1;
            }
        }
      
        // After the search, start is the least index where letters[index] > target,
        // since the array is circular, we use modulo operator to wrap around the index
        return letters[start % letters.length];
    }
}
