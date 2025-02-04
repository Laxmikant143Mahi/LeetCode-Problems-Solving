class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] result = new int[row][col];

        // Directions for 8 neighbors and the current cell
        int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = img[i][j];  // Include the current pixel
                int count = 1;

                // Check all 8 neighbors
                for (int k = 0; k < 8; k++) {
                    int ni = i + dirX[k];
                    int nj = j + dirY[k];

                    if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                        sum += img[ni][nj];
                        count++;
                    }
                }
                
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
