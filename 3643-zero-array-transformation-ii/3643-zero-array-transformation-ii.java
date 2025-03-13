class Solution {
    private int n; // Store the length of the nums array
    private int[] nums; // Array of numbers
    private int[][] queries; // Array of queries, each query is an array of 3 elements

    /**
     * Method to find the minimum number of queries needed to make all elements in nums non-positive.
     *
     * @param nums    The initial array of numbers.
     * @param queries Array of queries, where each query is represented by [l, r, value].
     * @return The minimum number of queries required to achieve the desired result, or -1 if not possible.
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length;
        int m = queries.length;
        int left = 0, right = m + 1; // Initialize binary search boundaries

        // Binary search to find the minimal number of queries needed
        while (left < right) {
            int mid = (left + right) >> 1; // Calculate the midpoint
            if (check(mid)) {
                right = mid; // Try a smaller number of queries if the current middle value works
            } else {
                left = mid + 1; // Otherwise, increase the number of queries
            }
        }
        return left > m ? -1 : left; // If 'left' exceeds 'm', it means no solution exists
    }

    /**
     * Helper method to check if the first 'k' queries can make all elements in nums[] non-positive.
     *
     * @param k The number of queries to consider.
     * @return true if possible, false otherwise.
     */
    private boolean check(int k) {
        int[] deltaArray = new int[n + 1]; // Array for handling range updates efficiently

        // Apply the first 'k' queries to the deltaArray
        for (int i = 0; i < k; ++i) {
            int l = queries[i][0], r = queries[i][1], value = queries[i][2];
            deltaArray[l] += value;
            deltaArray[r + 1] -= value;
        }

        // Calculate the prefix sum and check if nums[i] can be made non-positive
        for (int i = 0, sum = 0; i < n; ++i) {
            sum += deltaArray[i]; // Update sum using the delta array
            if (nums[i] > sum) {
                return false; // nums[i] cannot be made non-positive
            }
        }
        return true;
    }
}