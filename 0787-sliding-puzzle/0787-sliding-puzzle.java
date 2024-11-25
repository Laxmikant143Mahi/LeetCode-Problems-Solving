class Solution {
    private static final int ROWS = 2; // The number of rows in the puzzle
    private static final int COLS = 3; // The number of columns in the puzzle

    public int slidingPuzzle(int[][] board) {
        String startState = ""; // Convert the initial 2D board state to a string
        String targetState = "123450"; // The goal state we need to reach
      
        // Create a string without the empty tile to check puzzle solvability later
        StringBuilder solvabilitySequence = new StringBuilder();
      
        // Convert the board into a startState string and solvabilitySequence string
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                startState += board[i][j];
                if (board[i][j] != 0) {
                    solvabilitySequence.append(board[i][j]);
                }
            }
        }
      
        // Check if the puzzle is solvable
        if (!isPuzzleSolvable(solvabilitySequence.toString())) {
            return -1;
        }
      
        // Use a priority queue to perform A* search
        PriorityQueue<Pair<Integer, String>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
              
        Map<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(startState, 0);
        queue.offer(new Pair<>(calculateHeuristic(startState), startState));
      
        int[] directions = {-1, 0, 1, 0, -1}; // Direction vectors for adjacent moves
      
        while (!queue.isEmpty()) {
            Pair<Integer, String> pair = queue.poll();
            String state = pair.getValue();
            int steps = distanceMap.get(state);
          
            // If the final state is reached, return the number of steps taken
            if (targetState.equals(state)) {
                return steps;
            }
          
            int zeroIndex = state.indexOf("0");
            int row = zeroIndex / COLS, col = zeroIndex % COLS;
          
            char[] currentStateArray = state.toCharArray();
          
            // Try to slide an adjacent tile into the empty space
            for (int k = 0; k < 4; k++) {
                int newRow = row + directions[k], newCol = col + directions[k + 1];
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
                    int newIndex = newRow * COLS + newCol;
                  
                    // Swap the empty space with the adjacent tile
                    swap(currentStateArray, zeroIndex, newIndex);
                    String nextState = String.valueOf(currentStateArray);
                  
                    // Update the minimum distance if we find a better path
                    if (!distanceMap.containsKey(nextState) || distanceMap.get(nextState) > steps + 1) {
                        distanceMap.put(nextState, steps + 1);
                        queue.offer(new Pair<>(steps + 1 + calculateHeuristic(nextState), nextState));
                    }
                    // Swap back to the original state to try other moves
                    swap(currentStateArray, zeroIndex, newIndex);
                }
            }
        }
        return -1; // If we reach this point, no solution has been found
    }

    // Method to swap two characters in a character array
    private void swap(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Heuristic function for A* search that counts Manhattan distance to the goal state
    private int calculateHeuristic(String state) {
        int heuristic = 0;
        for (int i = 0; i < ROWS * COLS; i++) {
            if (state.charAt(i) != '0') {
                int num = state.charAt(i) - '1';
                heuristic += Math.abs(i / COLS - num / COLS) + Math.abs(i % COLS - num % COLS);
            }
        }
        return heuristic;
    }

    // Method to check if the puzzle is solvable by counting the number of inversions
    private boolean isPuzzleSolvable(String s) {
        int inversions = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    inversions++;
                }
            }
        }
        // A state is solvable if the inversion count is even
        return inversions % 2 == 0;
    }
}
