class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,max=0,sum=0,length=Integer.MAX_VALUE;
        for(r=0;r<nums.length;r++){
            sum=sum+nums[r];
            while(sum>=target){
                max=r-l+1;
                if(max<length){
                    length=max;
                }
                sum=sum-nums[l];
                l++;
            }
        }
        if(length==Integer.MAX_VALUE)
        return 0;
        else
        return length;
    }
}