class Solution {

    // Checks if a digit can be placed at board[row][col] without violating Sudoku rules
    public boolean canPlaceDigit(char[][] board, int row, int col, char digit) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solves the Sudoku board using backtracking
    public boolean sudokuHelper(char[][] board, int row, int col) {
        // If all rows are processed, the board is solved
        if (row == 9)
            return true;

        // Move to the next cell
        int nextRow = row;
        int nextCol = col + 1;

        // If the end of the column is reached, move to the next row
        if (nextCol == 9) {
            nextRow = nextRow + 1;
            nextCol = 0;
        }

        // If the cell is already filled, skip it
        if (board[row][col] != '.') {
            return sudokuHelper(board, nextRow, nextCol);
        }

        // Try placing digits 1-9 and check validity
        for (char digit = '1'; digit <= '9'; digit++) {
            if (canPlaceDigit(board, row, col, digit)) {
                board[row][col] = digit; // Place digit

                // Recur to solve the rest of the board
                if (sudokuHelper(board, nextRow, nextCol))
                    return true;

                board[row][col] = '.'; // Backtrack if placement is invalid
            }
        }
        return false; // No valid placement found
    }

    // Main function to solve the Sudoku board
    public void solveSudoku(char[][] board) {
        sudokuHelper(board, 0, 0);
    }
}
