class Solution {
    public int minimumTime(int[][] grid) {
        // Check for a situation where the path is blocked just next to the starting point
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        // m is the number of rows and n is the number of columns in the grid
        int m = grid.length, n = grid[0].length;

        // dist array holds the minimum time to reach each cell
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE); // Fill with a large number to represent infinity
        }
        // Starting point has a distance of 0
        dist[0][0] = 0;

        // Priority queue for efficient retrieval of the next cell to process
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.offer(new int[]{0, 0, 0}); // Add starting cell to the queue

        // Directions for moving up, left, down, right
        int[] directions = {-1, 0, 1, 0, -1};

        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            int time = cell[0], i = cell[1], j = cell[2];

            // If we're at the bottom-right corner, return the distance
            if (i == m - 1 && j == n - 1) {
                return time;
            }

            // Explore all possible directions (up, left, down, right)
            for (int k = 0; k < 4; k++) {
                int nextX = i + directions[k];
                int nextY = j + directions[k + 1];

                // Check if the new position is within the bounds of the grid
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    int nextTime = time + 1;

                    // If waiting time is required, wait until the path is clear
                    if (nextTime < grid[nextX][nextY]) {
                        nextTime = grid[nextX][nextY] + (grid[nextX][nextY] - nextTime) % 2;
                    }

                    // If a shorter path to (nextX, nextY) is found, update the distance and add to the queue
                    if (nextTime < dist[nextX][nextY]) {
                        dist[nextX][nextY] = nextTime;
                        priorityQueue.offer(new int[]{nextTime, nextX, nextY});
                    }
                }
            }
        }

        // If we reach this point, there is no path to the bottom-right corner, return -1
        return -1;
    }
}