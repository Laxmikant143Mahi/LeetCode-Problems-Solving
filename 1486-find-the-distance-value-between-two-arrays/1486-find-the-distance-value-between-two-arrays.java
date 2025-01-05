class Solution {
  
    // This function finds the distance value between two arrays.
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Sort the second array to perform binary search later.
        Arrays.sort(arr2);
      
        // Initialize answer to count the number of elements meeting the condition.
        int answer = 0;
      
        // Loop over each element in the first array.
        for (int elemArr1 : arr1) {
            // Check if the element in the first array meets the distance condition.
            if (isDistanceMoreThanD(arr2, elemArr1, d)) {
                // Increment the answer if the condition is met.
                answer++;
            }
        }
        // Return the number of elements that meet the condition.
        return answer;
    }

    // Helper function to check if the distance between an element and all elements in another array is more than d.
    private boolean isDistanceMoreThanD(int[] sortedArr2, int elemArr1, int d) {
        int left = 0;
        int right = sortedArr2.length;
      
        // Perform a binary search to find if there exists an element in arr2 that is within distance d of elemArr1.
        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow compared to (left + right) / 2.
            if (sortedArr2[mid] >= elemArr1 - d) {
                // If the middle element is within the lower bound of the distance, narrow the search to the left part.
                right = mid;
            } else {
                // Otherwise, narrow the search to the right part.
                left = mid + 1;
            }
        }
      
        // After the binary search, if the left index is out of bounds, it means all elements in arr2 are less than elemArr1 - d.
        // If the left index points to an element, that element must be greater than elemArr1 + d to satisfy the condition.
        return left >= sortedArr2.length || sortedArr2[left] > elemArr1 + d;
    }
}