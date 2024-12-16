class Solution {
    public int countElements(int[] nums) {
        
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){

            maxElement = Math.max(maxElement, nums[i]);

            minElement = Math.min(minElement, nums[i]);
        }

        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>minElement && nums[i]<maxElement){
                count++;
            }
        }
        return count;
    }
}