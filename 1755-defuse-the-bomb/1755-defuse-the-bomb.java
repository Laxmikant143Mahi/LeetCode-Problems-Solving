class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length; // Length of the code array.
        int[] answer = new int[n]; // The resultant array after decryption.
      
        // If k is 0, then the decryption is a zero array of length n.
        if (k == 0) {
            return answer;
        }
      
        // Create a sum array with size double the code (to handle wrap around) plus one (for easing the prefix sum calculation).
        int[] sum = new int[n * 2 + 1];
      
        // Compute the prefix sums for the array.
        for (int i = 0; i < n * 2; ++i) {
            sum[i + 1] = sum[i] + code[i % n];
        }
      
        // Process each element in the code array.
        for (int i = 0; i < n; ++i) {
            // If k is positive, sum the next k elements including the current one.
            if (k > 0) {
                answer[i] = sum[i + k + 1] - sum[i + 1];
            } else {
                // If k is negative, sum the k elements before the current one.
                answer[i] = sum[i + n] - sum[i + k + n];
            }
        }
      
        // Return the decrypted code.
        return answer;
    }
}