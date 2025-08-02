class Solution {
    public int longestConsecutive(int[] nums) {
        
        Arrays.sort(nums);
        if(nums.length==0) return 0;

        int max = 1, maxDist = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){

                continue;
            }
            if(nums[i] == nums[i+1] -1){
                max++;
                maxDist = Math.max(maxDist, max);
            }else{
                max = 1;
            }
        }
        return maxDist;
    }
}