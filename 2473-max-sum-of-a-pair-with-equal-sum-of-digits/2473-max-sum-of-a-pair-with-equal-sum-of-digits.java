class Solution {

    public int digitSum(int no){

        int rem =0, sum=0;

        while(no>0){

            rem = no%10;
            sum+=rem;
            no/=10;
        }

        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();


        int n = nums.length;
        int maxSum=-1;
        for(int i=0; i<n; i++){

            int sum = digitSum(nums[i]);

            if(map.containsKey(sum)){

                maxSum = Math.max(map.get(sum)+nums[i], maxSum);
            }
            
            if(map.containsKey(sum) && map.get(sum) < nums[i])
                 map.put(sum,nums[i]);
            else if(!map.containsKey(sum))
                 map.put(sum,nums[i]);

        }

        return maxSum;
    }
}