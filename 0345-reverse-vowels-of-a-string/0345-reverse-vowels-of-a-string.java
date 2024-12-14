class Solution {
    public String reverseVowels(String s) {
        // Create a set of vowels for quick lookup
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Initialize two pointers
        int start = 0, end = s.length() - 1;

        // Convert the string into a mutable StringBuilder
        StringBuilder sb = new StringBuilder(s);

        while (start < end) {
            // Move `start` forward if it is not a vowel
            if (!set.contains(sb.charAt(start))) {
                start++;
                continue;
            }

            // Move `end` backward if it is not a vowel
            if (!set.contains(sb.charAt(end))) {
                end--;
                continue;
            }

            // Swap vowels at `start` and `end`
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            // Move both pointers
            start++;
            end--;
        }

        // Return the modified string
        return sb.toString();
    }
}
