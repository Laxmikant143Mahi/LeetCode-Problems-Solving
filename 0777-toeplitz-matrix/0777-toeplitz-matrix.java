class Solution {
    /**
     * Checks if a given matrix is a Toeplitz matrix.
     * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
     *
     * @param matrix The input matrix to check.
     * @return true if the matrix is Toeplitz; otherwise, false.
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // m is the number of rows in the matrix
        int numRows = matrix.length;
        // n is the number of columns in the matrix
        int numCols = matrix[0].length;
      
        // Start from the second row and column because we will be comparing with the element above and to the left
        for (int i = 1; i < numRows; ++i) {
            for (int j = 1; j < numCols; ++j) {
                // If the current element is not the same as the one above and to the left, return false
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
      
        // If all diagonals from top-left to bottom-right have the same elements, return true
        return true;
    }
}