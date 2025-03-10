class Solution {
    public int[] runningSum(int[] nums) {
        
        int n = nums.length;
        int running[] = new int[n];

        running[0] = nums[0];

        for(int i=1; i<n; i++)
            running[i] = running[i-1]+nums[i];
        
        return running;
    }
}