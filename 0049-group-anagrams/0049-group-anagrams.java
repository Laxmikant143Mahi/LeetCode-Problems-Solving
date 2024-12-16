class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as the key and list of anagrams as the value
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each string in the input array
        for (String str : strs) {
            // Convert the string to a character array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            // Use the sorted string as a key
            String key = new String(chars);

            // If the key is not already in the map, add a new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add the original string to the list associated with the key
            map.get(key).add(str);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
