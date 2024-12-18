class Solution {
    public int minElement(int[] nums) {
        
        int minSum = Integer.MAX_VALUE;
        
        int rem = 0, sum=0;

        for(int num : nums){

            while(num>0){
                rem = num%10;
                sum+=rem;
                num/=10;
            }
            minSum = Math.min(minSum,sum);
            sum=0;
        }

        return minSum;
    }
}