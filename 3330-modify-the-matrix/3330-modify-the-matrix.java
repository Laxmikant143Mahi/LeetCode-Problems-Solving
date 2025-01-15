class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < col; i++) { // Iterate column by column
            int maxElement = Integer.MIN_VALUE;

            // Step 1: Find the maximum in the current column
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] != -1) {
                    maxElement = Math.max(maxElement, matrix[j][i]);
                }
            }

            // Step 2: Replace -1 in the column with the maximum value
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = maxElement;
                }
            }
        }

        return matrix;
    }
}
