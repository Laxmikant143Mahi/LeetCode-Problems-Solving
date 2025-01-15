class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Step 1: Find the maximum element in each column
        int[] maxInColumn = new int[col];
        for (int i = 0; i < col; i++) {
            int maxElement = Integer.MIN_VALUE;
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] != -1) {
                    maxElement = Math.max(maxElement, matrix[j][i]);
                }
            }
            maxInColumn[i] = maxElement; // Store the max value for the column
        }

        // Step 2: Replace all -1 in each column with the maximum value
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = maxInColumn[i]; // Replace -1 with the column's max value
                }
            }
        }

        return matrix;
    }
}
