class Solution {
    private long[][] memo; // memoization table to store computed values
    private List<Integer> robots; // list storing robot positions
    private int[][] factories; // 2D array storing factory positions and capacities

    // Computes the minimum total distance that robots must travel to factories
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        // Sort factories based on their positions (x-coordinate)
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);
      
        this.robots = robots;
        this.factories = factories;
        // Initialize the memoization table with robot size and factory length dimensions
        memo = new long[robots.size()][factories.length];
        return dfs(0, 0); // Begin the depth-first search from the start
    }

    // Depth-first search function to find minimum distance recursively
    private long dfs(int robotIndex, int factoryIndex) {
        // If all robots have been assigned to factories, no distance to cover
        if (robotIndex == robots.size()) {
            return 0;
        }
        // If there are no more factories to consider, return a large number to signify an invalid path
        if (factoryIndex == factories.length) {
            return Long.MAX_VALUE / 1000; // Large value to avoid overflow when further added
        }
        // If the value has been computed before, return it
        if (memo[robotIndex][factoryIndex] != 0) {
            return memo[robotIndex][factoryIndex];
        }
      
        // Recursive case: compare not assigning any more robots to current factory vs assigning more robots
        long ans = dfs(robotIndex, factoryIndex + 1); // Case of not assigning the robot to the current factory
      
        long distanceSum = 0; // Variable to keep the sum of distances if current factory is selected
        // Check assigning robots to this factory based on its capacity
        for (int k = 0; k < factories[factoryIndex][1]; ++k) {
            if (robotIndex + k == robots.size()) {
                break; // Break if there are no more robots to assign
            }
            // Add the distance of the k-th robot to the current factory to distanceSum
            distanceSum += Math.abs(robots.get(robotIndex + k) - factories[factoryIndex][0]);
            ans = Math.min(ans, distanceSum + dfs(robotIndex + k + 1, factoryIndex + 1));
        }
        memo[robotIndex][factoryIndex] = ans; // Memoize the computed result
      
        return ans; // Return the minimum distance for the current state
    }
}
