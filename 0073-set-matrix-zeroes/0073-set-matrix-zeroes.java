class Solution {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        boolean firstColHasZero = false; // Flag for the first column
        
        // Traverse the matrix to mark zeroes in the first row and column
        for (int row = 0; row < rowCount; ++row) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true; // Mark first column if it contains a zero
            }
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0; // Mark the row
                    matrix[0][col] = 0; // Mark the column
                }
            }
        }

        // Set matrix elements to zero using the markers
        for (int row = 1; row < rowCount; ++row) {
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Nullify the first row if needed
        if (matrix[0][0] == 0) {
            for (int col = 0; col < colCount; ++col) {
                matrix[0][col] = 0;
            }
        }

        // Nullify the first column if needed
        if (firstColHasZero) {
            for (int row = 0; row < rowCount; ++row) {
                matrix[row][0] = 0;
            }
        }
    }
}
