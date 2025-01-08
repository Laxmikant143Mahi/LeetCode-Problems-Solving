class Solution {
    public int lastStoneWeight(int[] stones) {
        

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<stones.length; i++)
            queue.add(stones[i]);
        
        
        while(queue.size()>1){

            int stone1 = queue.poll();
            int stone2 = queue.poll();

            if(stone1!=stone2){

                int weight = stone1-stone2;

                queue.add(weight);
            }
        }

        if(queue.size()==0)
            return 0;
        else 
            return queue.poll();
    }
}