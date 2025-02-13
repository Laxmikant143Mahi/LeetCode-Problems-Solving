class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++)
            queue.add((long)nums[i]);

        int op=0;
        while(queue.peek()<k && queue.size()>1){

            long first = queue.poll();
            long second = queue.poll();

            queue.add(Math.min(first,second)*2+Math.max(first,second));

            op++;
        }

        if(queue.peek()>=k) return op;
        return -1;
        
    }
}