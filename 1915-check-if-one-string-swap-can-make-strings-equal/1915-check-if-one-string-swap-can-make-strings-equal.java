class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int n = s1.length();
        int first = -1, second = -1; // Indices of mismatch

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;  // First mismatch
                } else if (second == -1) {
                    second = i; // Second mismatch
                } else {
                    return false; // More than two mismatches
                }
            }
        }

        // Ensure only two mismatches and swapping fixes the issue
        return second != -1 && 
               s1.charAt(first) == s2.charAt(second) && 
               s1.charAt(second) == s2.charAt(first);
    }
}
