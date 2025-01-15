class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // Check if the reshape is possible
        if (mat.length * mat[0].length != r * c) {
            return mat; // Return the original matrix if reshape is not possible
        }

        // Initialize the new reshaped matrix
        int[][] newMat = new int[r][c];
        
        // Variable to keep track of the linear index in the original matrix
        int count = 0;

        // Fill the new matrix by iterating row by row
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Map the linear index in the original matrix to the reshaped matrix
                int originalRow = count / mat[0].length;
                int originalCol = count % mat[0].length;
                newMat[i][j] = mat[originalRow][originalCol];
                count++;
            }
        }

        return newMat; // Return the reshaped matrix
    }
}
