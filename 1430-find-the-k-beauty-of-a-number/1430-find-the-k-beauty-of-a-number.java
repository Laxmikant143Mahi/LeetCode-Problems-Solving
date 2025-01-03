class Solution {

    // This method counts the number of k-digit long substrings within the number num that are divisors of num.
    public int divisorSubstrings(int num, int k) {
        int countDivisors = 0; // This will be the count of divisors
        String numberAsString = Integer.toString(num); // Convert the number to a string
      
        // Loop through the string representation of num to extract substrings of length k
        for (int i = 0; i <= numberAsString.length() - k; ++i) {
            // Extract the substring of length k starting at index i
            int substringAsInt = Integer.parseInt(numberAsString.substring(i, i + k));

            // Check for both non-zero substrings and if num is divisible by the substring
            if (substringAsInt != 0 && num % substringAsInt == 0) {
                countDivisors++; // If it's a divisor, increment the count
            }
        }
        return countDivisors; // Return the count of k-digit divisors of num
    }
}