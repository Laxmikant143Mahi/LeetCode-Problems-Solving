import java.util.HashMap;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int repeated = -1;
        int actualSum = 0;

        int row = grid.length;
        int col = grid[0].length;

        // Total numbers from 1 to n * m
        int totalNumbers = row * col;
        int expectedSum = (totalNumbers * (totalNumbers + 1)) / 2; // Sum of first n natural numbers

        // Calculate actual sum and identify the repeated number
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = grid[i][j];
                map.put(num, map.getOrDefault(num, 0) + 1);

                if (map.get(num) == 2) {
                    repeated = num;
                }

                actualSum += num;
            }
        }

        // Missing number calculation
        int missing = expectedSum - (actualSum - repeated);

        return new int[] {repeated, missing};
    }
}
