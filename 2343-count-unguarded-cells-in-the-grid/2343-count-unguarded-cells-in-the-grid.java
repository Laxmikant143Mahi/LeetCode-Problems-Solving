class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize the grid representation where
        // 0 represents an unguarded cell,
        // 1 represents a cell guarded by a guard's line of sight,
        // 2 represents an occupied cell by either a guard or a wall.
        int[][] grid = new int[m][n];

        // Mark all the guard positions on the grid.
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark all the wall positions on the grid.
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // This array represents the directional increments: up, right, down, and left.
        int[] directions = {-1, 0, 1, 0, -1};

        // Iterate over each guard and mark their line of sight until they hit a wall or the grid's edge.
        for (int[] guard : guards) {
            // Four directions - up, right, down, left
            for (int k = 0; k < 4; ++k) {
                // Starting position for the current guard.
                int x = guard[0], y = guard[1];
                // Directional increments for the current direction.
                int deltaX = directions[k], deltaY = directions[k + 1];
                // Keep marking the grid in the current direction till
                // you hit a wall, guard or boundary of the grid.
                while (x + deltaX >= 0 && x + deltaX < m && y + deltaY >= 0 && y + deltaY < n && grid[x + deltaX][y + deltaY] < 2) {
                    x += deltaX;
                    y += deltaY;
                    grid[x][y] = 1; // Marking the cell as guarded.
                }
            }
        }

        // Count all the unguarded spaces, where the grid value is 0.
        int unguardedCount = 0;
        for (int[] row : grid) {
            for (int cellValue : row) {
                if (cellValue == 0) {
                    unguardedCount++;
                }
            }
        }
      
        // Return the total number of unguarded cells.
        return unguardedCount;
    }
}