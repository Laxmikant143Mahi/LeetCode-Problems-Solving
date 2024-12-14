class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i=0; i<nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        }

        int count=0;
        int maxFreq=0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            maxFreq = Math.max(maxFreq,entry.getValue());
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            if(entry.getValue()==maxFreq){
                count+=entry.getValue();
            }
        }
        return count;

    }
}