class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int incCount=1;
        int maxInc = 1;
     

        for(int i=0; i<n-1; i++){

            if(nums[i] < nums[i+1]){
                incCount++;
            }else{
                incCount=1;
            }

            maxInc = Math.max(maxInc, incCount);
            
        }
           int maxDec = 1;
           int decCount=1;
         for(int i=0; i<n-1; i++){

            if(nums[i] > nums[i+1]){
                decCount++;
            }else{
                decCount=1;
            }

            maxDec = Math.max(maxDec, decCount);
            
         }
         return Math.max(maxInc, maxDec);

    }
}