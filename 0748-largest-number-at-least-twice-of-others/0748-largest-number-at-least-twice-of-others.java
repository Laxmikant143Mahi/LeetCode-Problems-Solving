class Solution {
    public int dominantIndex(int[] nums) {
        
        int maxElement = Integer.MIN_VALUE;
        int n = nums.length;
        int index = -1;

        for(int i=0; i<n; i++){
            if(maxElement < nums[i]){

                maxElement = nums[i];
                index = i;
            }
        }
            
        
        for(int i=0; i<n; i++){
            if(nums[i]!=maxElement && !(maxElement>=2*nums[i])){
                return -1;
            }
        }
        return index;

    }
}