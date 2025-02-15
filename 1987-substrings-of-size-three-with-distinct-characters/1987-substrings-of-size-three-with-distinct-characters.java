class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0; // If the string is shorter than 3, no valid substrings exist.

        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) { // Check if all three characters are distinct
                count++;
            }
        }

        return count;
    }
}
