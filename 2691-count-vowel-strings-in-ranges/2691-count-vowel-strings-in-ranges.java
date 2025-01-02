class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefSum = new int[n];
        String vowels = "aeiou";

        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            String word = words[i];
            boolean startsWithVowel = vowels.indexOf(word.charAt(0)) != -1;
            boolean endsWithVowel = vowels.indexOf(word.charAt(word.length() - 1)) != -1;

            if (startsWithVowel && endsWithVowel) {
                prefSum[i] = (i == 0) ? 1 : prefSum[i - 1] + 1;
            } else {
                prefSum[i] = (i == 0) ? 0 : prefSum[i - 1];
            }
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
