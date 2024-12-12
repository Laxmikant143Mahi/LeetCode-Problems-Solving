class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0; // To store the maximum length of substring
        int start = 0; // Pointer to the start of the current substring

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is already in the map and is within the current substring
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Move the start to the position after the last occurrence of the current character
                start = map.get(currentChar) + 1;
            }

            // Update the character's latest index in the map
            map.put(currentChar, i);

            // Calculate the current substring length and update maxLength
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength; // Return the maximum length of substring found
    }
}
