class Solution {
    public int maxVowels(String s, int k) {

        // Vowel set
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Prefix sum array
        int pref[] = new int[s.length()];
        
        // Count vowels for the first character
        if (set.contains(s.charAt(0))) {
            pref[0] = 1;
        } else {
            pref[0] = 0;
        }

        // Build prefix sum array
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = pref[i - 1];
            }
        }

        // Sliding window over the prefix array
        int maxCount = pref[k - 1]; // First window of size k
        for (int start = 1; start <= s.length() - k; start++) {
            int end = start + k - 1;
            int count = pref[end] - pref[start - 1];
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
