import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumberMap = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> numberToIndicesMap = new HashMap<>();

    // Constructor
    public NumberContainers() {
        // Intentionally left blank, no initialization needed here
    }

    /**
     * Updates the number at a given index and maintains the mapping of numbers to a sorted set of indices.
     *
     * @param index  The index to change.
     * @param number The new number to associate with the index.
     */
    public void change(int index, int number) {
        // If index already contains a number, update the mapping
        if (indexToNumberMap.containsKey(index)) {
            int currentNumber = indexToNumberMap.get(index);
            // Remove the index from the current number's set
            TreeSet<Integer> indicesSet = numberToIndicesMap.get(currentNumber);
            indicesSet.remove(index);
            // If the set is empty after removal, remove it from the map
            if (indicesSet.isEmpty()) {
                numberToIndicesMap.remove(currentNumber);
            }
        }
        // Add or update the index-to-number mapping
        indexToNumberMap.put(index, number);
        // Add index to the new number's set, creating the set if it doesn't exist
        numberToIndicesMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    /**
     * Finds the lowest index for a number.
     * If the number is not associated with any index, returns -1.
     *
     * @param number The number to find the lowest index for.
     * @return The lowest index of the given number or -1 if not found.
     */
    public int find(int number) {
        // Check if number exists in the map and return the first (lowest) index
        return numberToIndicesMap.containsKey(number) ? numberToIndicesMap.get(number).first() : -1;
    }
}

// The NumberContainers object usage remains the same; example of instantiation and method calls:
// NumberContainers obj = new NumberContainers();
// obj.change(index,number);
// int lowestIndex = obj.find(number);
