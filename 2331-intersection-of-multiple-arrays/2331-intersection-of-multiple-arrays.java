class Solution {
   public List<Integer> intersection(int[][] arrays) {
    // HashMap to store the count of each element
    Map<Integer, Integer> countMap = new HashMap<>();

    // Iterate through each sub-array
    for (int[] array : arrays) {
        for (int element : array) {
            // Increment the count for each element in the HashMap
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
    }

    // List to store the result (elements present in all sub-arrays)
    List<Integer> result = new ArrayList<>();

    // Check the HashMap for elements with a count equal to the number of arrays
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        if (entry.getValue() == arrays.length) {
            result.add(entry.getKey()); // Add to the result list if element is present in all arrays
        }
    }
    Collections.sort(result);
    // Return the result list
    return result;
}

}