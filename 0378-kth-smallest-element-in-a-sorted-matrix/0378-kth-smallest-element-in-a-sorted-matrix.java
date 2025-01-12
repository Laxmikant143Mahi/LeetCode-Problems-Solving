class Solution {
     // Custom Pair class
  static class Pair {
    int row, col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  static int kthSmallest(int mat[][], int k) {
    int n = mat.length;
    // Priority queue with simplified comparator
    PriorityQueue<Pair> pq = new PriorityQueue<>(
      (a, b) -> Integer.compare(mat[a.row][a.col], mat[b.row][b.col])
    );

    // Add the first element of each row to the priority queue
    for (int i = 0; i < n; i++) {
      pq.add(new Pair(i, 0));
    }

    // Extract the smallest element (k-1) times
    for (int i = 1; i < k; i++) {
      Pair current = pq.poll();

      // Push the next element from the same row if available
      if (current.col + 1 < n) {
        pq.add(new Pair(current.row, current.col + 1));
      }
    }

    // The kth smallest element will now be at the top of the priority queue
    Pair kthSmallestPair = pq.peek();
    return mat[kthSmallestPair.row][kthSmallestPair.col];
  }

}