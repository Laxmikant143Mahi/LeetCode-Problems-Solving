class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        int n = nums.length;
        for(int j=1; j<=k; j++){

            int minElement = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i=0; i<nums.length; i++){

                if(minElement>nums[i]){

                    minElement = nums[i];
                    minIndex = i;
                }

            }
            nums[minIndex] = minElement * multiplier;

        }

        return nums;
    }
}