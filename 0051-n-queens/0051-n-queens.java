import java.util.*;

class Solution {

    // Helper function to print the board (not necessary for the solution, but useful for debugging)
    public void printBoard(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    // Helper function to check if placing a Queen at board[row][col] is safe
    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Vertical check (left side)
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Horizontal check (above)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left check (above-left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right check (above-right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Backtracking function to solve N-Queens
    public int nQueens(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            printBoard(board); // Optional: This will print the board when a solution is found
            return 1;
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place the Queen
                count += nQueens(board, row + 1); // Recurse for the next row
                board[row][j] = '.'; // Backtrack
            }
        }

        return count;
    }

    // Main function to return all solutions as a list of strings
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start solving from the first row
        solveNQueensHelper(board, 0, result);
        return result;
    }

    // Helper function to collect the solutions into List<List<String>>
    public void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            // Convert the board to a list of strings and add to the result
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place the Queen
                solveNQueensHelper(board, row + 1, result); // Recurse for the next row
                board[row][j] = '.'; // Backtrack
            }
        }
    }
}
