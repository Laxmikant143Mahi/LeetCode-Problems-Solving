import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        // Min-heap to store (soldiers_count, row_index) pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        // Calculate soldier count for each row and add to the heap
        for (int i = 0; i < row; i++) {
            int soldiers = countSoldiers(mat[i]);
            pq.offer(new int[]{soldiers, i});
        }

        // Extract the indices of the k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }

    // Helper function to count the number of soldiers (1s) in a row
    private int countSoldiers(int[] row) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1; // Move right to count more soldiers
            } else {
                right = mid - 1; // Move left to find the last soldier
            }
        }
        return left; // Number of 1s in the row
    }
}
