class Solution {
    public int maxAscendingSum(int[] nums) {
        
       
        int n = nums.length;
        int curr_sum = nums[0], maxSum=nums[0];

        for(int i=0; i<n-1; i++){

            if(nums[i] < nums[i+1]){
                curr_sum+=nums[i+1];
            }else{
                curr_sum=nums[i+1];
            }

            maxSum = Math.max(curr_sum,maxSum);
        }

        return maxSum;
    }
}