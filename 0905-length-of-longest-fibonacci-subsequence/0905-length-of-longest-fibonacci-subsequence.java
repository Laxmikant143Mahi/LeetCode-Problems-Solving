class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // The length of the input array
        int length = arr.length;
        // Create a HashMap to store the index of each value in the array for quick lookup
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            indexMap.put(arr[i], i);
        }
        // Initialize the dynamic programming table where dp[i][j] will store
        // the length of the Fibonacci-like sequence ending with arr[i] and arr[j]
        int[][] dp = new int[length][length];
        // Initialize the table with the minimum possible sequence length, which is 2
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[j][i] = 2;
            }
        }
        // This will hold the length of the longest Fibonacci-like subsequence
        int longestSequenceLength = 0;
        // Iterate over all pairs of indices to build the longest sequence
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                // The potential previous value in the Fibonacci-like sequence
                int prevValue = arr[i] - arr[j];
                // Check if the needed previous value is in the array
                if (indexMap.containsKey(prevValue)) {
                    // The index k of the needed previous value
                    int k = indexMap.get(prevValue);
                    // Ensure the previous value's index comes before j
                    if (k < j) {
                        // Update the sequence length considering the triplet (arr[k], arr[j], arr[i])
                        dp[j][i] = Math.max(dp[j][i], dp[k][j] + 1);
                        // Update the global maximum length if necessary
                        longestSequenceLength = Math.max(longestSequenceLength, dp[j][i]);
                    }
                }
            }
        }
        // If the longestSequenceLength remains 2, no Fibonacci-like sequence is found,
        // so we return 0 as specified in the problem statement
        return longestSequenceLength > 2 ? longestSequenceLength : 0;
    }
}
