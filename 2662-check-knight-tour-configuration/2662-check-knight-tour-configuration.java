class Solution {

    // Recursive function to validate if the grid forms a knight's tour
    public boolean isValid(int[][] grid, int row, int col, int n, int expectedValue) {
        // Base case: Check if the position is out of bounds or the current cell doesn't match the expected value
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != expectedValue) {
            return false;
        }

        // If we reach the last expected value (n^2 - 1), the tour is valid
        if (expectedValue == Math.pow(n, 2) - 1) {
            return true;
        }

        // Check all 8 possible knight moves recursively
        boolean ans1 = isValid(grid, row - 2, col + 1, n, expectedValue + 1);
        boolean ans2 = isValid(grid, row - 1, col + 2, n, expectedValue + 1);
        boolean ans3 = isValid(grid, row + 1, col + 2, n, expectedValue + 1);
        boolean ans4 = isValid(grid, row + 2, col + 1, n, expectedValue + 1);
        boolean ans5 = isValid(grid, row + 2, col - 1, n, expectedValue + 1);
        boolean ans6 = isValid(grid, row + 1, col - 2, n, expectedValue + 1);
        boolean ans7 = isValid(grid, row - 1, col - 2, n, expectedValue + 1);
        boolean ans8 = isValid(grid, row - 2, col - 1, n, expectedValue + 1);

        // Return true if any of the recursive calls return true
        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    // Main function to check if the knight's tour is valid starting from (0, 0)
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);
    }
}
