class Solution {
    public int largestAltitude(int[] gain) {
        
        int sum = 0;
        int maxSum=0;
        int n = gain.length;

        for(int i=0; i<n; i++){
            sum+=gain[i];

            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}