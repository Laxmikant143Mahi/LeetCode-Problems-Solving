class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n]; // Array to store the result (common prefix counts)
        boolean[] seenA = new boolean[n + 1]; // Boolean array to track elements seen in A
        boolean[] seenB = new boolean[n + 1]; // Boolean array to track elements seen in B
        int commonCount = 0; // Variable to keep track of common elements count

        // Iterate through each index of A and B
        for (int i = 0; i < n; i++) {
            // Mark the current element in A as seen
            seenA[A[i]] = true;
            
            // Mark the current element in B as seen
            seenB[B[i]] = true;

            // If this is the first time the element in A is seen in B, increment common count
            if (seenB[A[i]]) {
                commonCount++;
            }

            // If this is the first time the element in B is seen in A, increment common count
            if (seenA[B[i]] && A[i] != B[i]) {
                commonCount++;
            }

            // Store the current count of common elements in the result array
            ans[i] = commonCount;
        }
        
        return ans; // Return the array containing the prefix common counts
    }
}