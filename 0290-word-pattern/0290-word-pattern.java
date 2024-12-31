class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the s string into individual words
        String[] words = s.split(" ");
      
        // If the number of characters in the pattern does not match the number of words, return false
        if (pattern.length() != words.length) {
            return false;
        }
      
        // Initialize two dictionaries to track the mappings from characters to words and vice versa
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();
      
        // Iterate over the pattern
        for (int i = 0; i < words.length; ++i) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];
          
            // If the current mapping from char to word or word to char does not exist or is inconsistent, return false
            if (!charToWordMap.getOrDefault(currentChar, currentWord).equals(currentWord) || wordToCharMap.getOrDefault(currentWord, currentChar) != currentChar) {
                return false;
            }
          
            // Update the mappings
            charToWordMap.put(currentChar, currentWord);
            wordToCharMap.put(currentWord, currentChar);
        }
      
        // If no inconsistencies are found, return true
        return true;
    }
}