class Solution {

    /**
     * Checks if the given sentence is circular. A sentence is considered circular
     * if the first and last characters are the same and each space is both preceded
     * and succeeded by the same character.
     *
     * @param sentence The input sentence as a string.
     * @return true if the sentence is circular, otherwise false.
     */
    public boolean isCircularSentence(String sentence) {
        int sentenceLength = sentence.length();

        // Check if the first and last characters are the same. 
        // If not, the sentence cannot be circular.
        if (sentence.charAt(0) != sentence.charAt(sentenceLength - 1)) {
            return false;
        }

        // Iterate through the characters of the sentence
        for (int i = 1; i < sentenceLength; ++i) {
            // Check if there is a space and if it is not flanked
            // by the same character on both sides. If not, return false.
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                return false;
            }
        }

        // If all checks are passed, the sentence is circular.
        return true;
    }
}