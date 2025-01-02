class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefSum = new int[n];
        boolean[] isVowelWord = new boolean[n];
        String vowels = "aeiou";

        // Precompute which words are vowel strings
        for (int i = 0; i < n; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            isVowelWord[i] = vowels.indexOf(first) != -1 && vowels.indexOf(last) != -1;
        }

        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefSum[i] = (i == 0 ? 0 : prefSum[i - 1]) + (isVowelWord[i] ? 1 : 0);
        }

        // Process queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefSum[right] - (left > 0 ? prefSum[left - 1] : 0);
        }

        return ans;
    }
}
