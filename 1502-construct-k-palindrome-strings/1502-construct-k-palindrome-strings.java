import java.util.HashMap;

class Solution {
    public boolean canConstruct(String inputString, int palindromeCount) {
        // Length of the input string
        int length = inputString.length();

        // If the input string is shorter than the required number of palindromes,
        // it is not possible to construct the palindromes.
        if (length < palindromeCount) {
            return false;
        }

        // HashMap to hold the frequency of each character in the inputString.
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        // Count the frequency of each character in the inputString.
        for (char c : inputString.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Count the number of characters that appear an odd number of times.
        int oddCount = 0;
        for (int frequency : charFrequency.values()) {
            if (frequency % 2 != 0) {
                oddCount++;
            }
        }

        // It is possible to form palindromes if the number of characters with
        // odd frequency is less than or equal to the number of palindromes we need to construct.
        return oddCount <= palindromeCount;
    }
}
