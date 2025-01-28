class Solution {
    public int maxFrequency(int[] nums, int k) {
        int totalK = 0;
        for (int num : nums) {
            if (num == k) {
                totalK++;
            }
        }
        
        int maxContribution = 0;
        
        for (int a = 1; a <= 50; a++) {
            if (a == k) {
                continue; // Skip when a is equal to k, as adding x=0 contributes nothing
            }
            int currentSum = 0;
            int maxSum = 0;
            for (int num : nums) {
                int val = 0;
                if (num == a) {
                    val = 1;
                } else if (num == k) {
                    val = -1;
                }
                currentSum = Math.max(val, currentSum + val);
                maxSum = Math.max(maxSum, currentSum);
            }
            maxContribution = Math.max(maxContribution, maxSum);
        }
        
        return maxContribution + totalK;
    }
}