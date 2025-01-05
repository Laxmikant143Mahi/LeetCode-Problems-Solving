class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray(); // Convert string to char array for mutability
        
        while (start < end) {
            // Check if both characters are letters
            if (Character.isLetter(arr[start]) && Character.isLetter(arr[end])) {
                // Swap characters
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } 
            // Move pointers if character is not a letter
            else if (!Character.isLetter(arr[start])) {
                start++;
            } else {
                end--;
            }
        }
        
        return new String(arr); // Convert char array back to string
    }
}
