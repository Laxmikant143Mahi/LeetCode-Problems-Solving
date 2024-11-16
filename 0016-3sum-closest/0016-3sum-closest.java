class Solution {
    public int threeSumClosest(int[] arr, int target) {
        
        Arrays.sort(arr); // Sort the array

        int closestSum = Integer.MAX_VALUE; // Variable to store the closest sum
        for (int start = 0; start < arr.length - 2; start++) { // Loop for the first element
            
            int end = arr.length - 1; // Set the end pointer to the last element
            int middle = start + 1; // Start pointer is always one ahead of 'start'

            while (middle < end) { // Check while middle pointer is less than end
                int currSum = arr[start] + arr[middle] + arr[end]; // Current sum of triplet

                if (currSum == target) {
                    return currSum; // If the sum is exactly equal to target, return it
                }
                
                // Update closest sum if the current sum is closer to target
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }

                if (currSum < target) {
                    middle++; // If the sum is less than target, move 'middle' pointer right
                } else {
                    end--; // If the sum is greater than target, move 'end' pointer left
                }
            }
        }
        
        return closestSum; // Return the closest sum found
    }
}
