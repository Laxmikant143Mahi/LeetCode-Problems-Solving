class Solution {
    public int maximumCandies(int[] candies, long k) {
        // Initialize the search range for the maximum number of candies per child.
        int low = 0;
        int high = (int) 1e7;
      
        // Use a binary search to find the maximum number of candies 
        // that can be distributed to `k` children evenly.
        while (low < high) {
            // Calculate the middle point of the current search range.
            // Use `+ 1` to ensure the `mid` is biased towards the higher part of the range.
            // The bitwise right shift operator `>> 1` effectively divides the sum of `low` and `high` by 2.
            int mid = (low + high + 1) >> 1;
          
            // Count the total number of children that can receive `mid` candies.
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
          
            // If the total number of children that can receive `mid` candies is at least `k`,
            // then we know that it's possible to give out at least `mid` candies to each child.
            // So we update `low` to `mid` to search in the higher half of the range next.
            if (count >= k) {
                low = mid;
            }
            // If not, we need to search in the lower half of the range, so we adjust `high`.
            else {
                high = mid - 1;
            }
        }
      
        // `low` will represent the highest number of candies that can be distributed evenly to `k` children.
        return low;
    }
}
