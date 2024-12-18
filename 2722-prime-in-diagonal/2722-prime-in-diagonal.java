class Solution {
     boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int largestPrime = 0; // To track the largest prime number
        
        // Helper function to check if a number is prime
       
        
        // Traverse both diagonals
        for (int i = 0; i < n; i++) {
            // Primary diagonal element: nums[i][i]
            if (isPrime(nums[i][i])) {
                largestPrime = Math.max(largestPrime, nums[i][i]);
            }
            
            // Secondary diagonal element: nums[i][n - i - 1]
            if (i != n - i - 1 && isPrime(nums[i][n - i - 1])) {
                largestPrime = Math.max(largestPrime, nums[i][n - i - 1]);
            }
        }
        
        return largestPrime;
    }
}
