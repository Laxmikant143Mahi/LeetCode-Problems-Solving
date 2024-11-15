class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // Find the length of the non-decreasing starting subarray.
        int left = 0, right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        // If the whole array is already non-decreasing, return 0.
        if (left == n - 1) {
            return 0;
        }
      
        // Find the length of the non-decreasing ending subarray.
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
      
        // Compute the length of the subarray to be removed, 
        // considering only one side (either starting or ending subarray).
        int minLengthToRemove = Math.min(n - left - 1, right);
      
        // Try to connect a prefix of the starting non-decreasing subarray
        // with a suffix of the ending non-decreasing subarray.
        for (int leftIdx = 0, rightIdx = right; leftIdx <= left; leftIdx++) {
            // Move the rightIdx pointer to the right until we find an element 
            // that is not less than the current element from the left side.
            while (rightIdx < n && arr[rightIdx] < arr[leftIdx]) {
                rightIdx++;
            }
            // Update the answer with the minimum length found so far.
            minLengthToRemove = Math.min(minLengthToRemove, rightIdx - leftIdx - 1);
        }
        return minLengthToRemove;
    }
}