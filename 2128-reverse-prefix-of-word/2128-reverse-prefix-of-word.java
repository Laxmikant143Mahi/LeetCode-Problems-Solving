class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int index = -1;

        // Find the index of the first occurrence of 'ch'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                index = i;
                break;
            }
        }

        // If 'ch' is not found, return the original word
        if (index == -1) {
            return word;
        }

        // Reverse the prefix using two pointers
        int left = 0, right = index;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }
}
