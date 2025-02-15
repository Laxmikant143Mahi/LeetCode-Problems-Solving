import java.util.HashSet;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();

        // Add broken letters to HashSet
        for (char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }

        String[] words = text.split(" "); // Split text into words
        int count = 0;

        // Check each word
        for (String word : words) {
            boolean canType = true;

            for (char ch : word.toCharArray()) {
                if (set.contains(ch)) {
                    canType = false;
                    break; // Stop checking if a broken letter is found
                }
            }

            if (canType) {
                count++;
            }
        }

        return count;
    }
}
