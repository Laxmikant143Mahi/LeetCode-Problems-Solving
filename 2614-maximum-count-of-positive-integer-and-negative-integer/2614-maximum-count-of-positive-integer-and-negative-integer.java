class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;

        int n = nums.length;

        for(int i=0; i<n ;i++){
            int no = nums[i];

            if(no>0) pos++;
            else if(no<0) neg++;
        }

        return Math.max(pos,neg);
    }
}