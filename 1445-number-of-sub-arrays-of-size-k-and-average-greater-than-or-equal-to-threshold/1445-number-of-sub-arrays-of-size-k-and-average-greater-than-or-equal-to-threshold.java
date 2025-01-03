class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // Initialize the sum of the first 'k' elements.
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }
      
        // Calculate the initial average and determine if it meets or exceeds the threshold.
        // Increment the count if it does.
        int count = (sum / k >= threshold) ? 1 : 0;
      
        // Slide the window of size 'k' across the array and update the sum and count accordingly.
        for (int i = k; i < arr.length; ++i) {
            // Update the sum by adding the new element and subtracting the oldest element.
            sum += arr[i] - arr[i - k];
          
            // If the updated average meets or exceeds the threshold, increase the count.
            count += (sum / k >= threshold) ? 1 : 0;
        }
      
        // Return the total count of subarrays that meet the threshold condition.
        return count;
    }
}