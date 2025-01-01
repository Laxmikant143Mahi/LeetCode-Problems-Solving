class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i + 1;
            int rightCount = n - i;

            // Total subarrays including arr[i]
            int totalSubarrays = leftCount * rightCount;

            // Count of odd-length subarrays
            int oddSubarrays = (totalSubarrays + 1) / 2;

            // Contribution of arr[i] to the sum
            totalSum += oddSubarrays * arr[i];
        }

        return totalSum;
    }
}
