class Solution {
    public int minimumObstacles(int[][] grid) {
        // Get the dimensions of the grid
        int rows = grid.length, cols = grid[0].length;

        // Create a deque to hold the positions and the current obstacle count
        Deque<int[]> queue = new ArrayDeque<>();
        // Start from the upper left corner (0,0) with 0 obstacles
        queue.offer(new int[] {0, 0, 0});
        // Array to iterate over the 4 possible directions (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};
        // Visited array to keep track of positions already visited
        boolean[][] visited = new boolean[rows][cols];

        // Process cells until the queue is empty
        while (!queue.isEmpty()) {
            // Poll the current position and the number of obstacles encountered so far
            int[] position = queue.poll();
            int currentRow = position[0];
            int currentCol = position[1];
            int obstacles = position[2];

            // Check if we have reached the bottom-right corner
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                // If we reached the destination, return the number of obstacles encountered
                return obstacles;
            }

            // If we have already visited this cell, skip it
            if (visited[currentRow][currentCol]) {
                continue;
            }

            // Mark the current cell as visited
            visited[currentRow][currentCol] = true;

            // Explore the neighboring cells
            for (int h = 0; h < 4; ++h) {
                int nextRow = currentRow + directions[h];
                int nextCol = currentCol + directions[h + 1];

                // Check the boundaries of the grid
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    // If the next cell is free (no obstacle)
                    if (grid[nextRow][nextCol] == 0) {
                        // Add it to the front of the queue to be processed with the same obstacle count
                        queue.offerFirst(new int[] {nextRow, nextCol, obstacles});
                    } else {
                        // If there's an obstacle, add it to the end of the queue with the obstacle count incremented by 1
                        queue.offerLast(new int[] {nextRow, nextCol, obstacles + 1});
                    }
                }
            }
        }
        // We include a return statement to satisfy the compiler, although the true return occurs inside the loop
        return -1; // This will never be reached as the problem guarantees a path exists
    }
}
