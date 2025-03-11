class Solution {
    public int numberOfSubstrings(String s) {
        // Array to store the latest positions of characters 'a', 'b', and 'c'
        int[] latestPosition = new int[] {-1, -1, -1};
      
        // This will hold the count of valid substrings
        int answer = 0;
      
        // Iterate over each character in the string
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
          
            // Update the latest position of the current character
            latestPosition[currentChar - 'a'] = i;
          
            // Find the smallest index among the latest positions of 'a', 'b', and 'c'
            // and add 1 to get the count of valid substrings ending with the current character
            int minPosition = Math.min(latestPosition[0], Math.min(latestPosition[1], latestPosition[2]));
            answer += minPosition + 1;
        }
      
        return answer; // Return the total count of valid substrings
    }
}