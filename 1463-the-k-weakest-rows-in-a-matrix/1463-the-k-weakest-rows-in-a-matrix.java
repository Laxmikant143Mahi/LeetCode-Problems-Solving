import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the number of soldiers in each row
        for (int i = 0; i < row; i++) {
            int soldiers = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break; // Optimization: Stop counting when we hit a '0'
                }
            }
            map.put(i, soldiers);
        }

        // Use a priority queue to sort rows by soldier count and then by row index
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> a.getValue().equals(b.getValue())
                ? Integer.compare(a.getKey(), b.getKey()) // Compare row indices if counts are equal
                : Integer.compare(a.getValue(), b.getValue()) // Compare soldier counts
        );

        // Add all rows to the priority queue
        queue.addAll(map.entrySet());

        // Extract the indices of the k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}
