class Solution {
    public String largestOddNumber(String num) {
        
        // Iterate from the end to the beginning
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current character is an odd number
            if (Integer.parseInt(num.charAt(i) + "") % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd number is found, return an empty string
        return "";
    }
}