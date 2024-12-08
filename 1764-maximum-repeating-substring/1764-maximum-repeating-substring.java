class Solution {
    public int maxRepeating(String sequence, String word) {
        
           int count = 0;
        String pattern = word;

        // Keep appending `word` to `pattern` and check if it exists in `sequence`
        while (sequence.contains(pattern)) {
            count++;
            pattern += word;
        }

        return count;
    }
}