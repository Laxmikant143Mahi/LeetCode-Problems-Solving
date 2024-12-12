class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        while(k>0){
            
            int maxGift=0, maxIndex=0;
            for(int i=0; i<gifts.length; i++){

                    if(gifts[i]>maxGift){
                        maxGift = gifts[i];
                        maxIndex = i;
                    }

            }

            int sqrt = (int) Math.floor(Math.sqrt(gifts[maxIndex]));
            gifts[maxIndex] = sqrt;
            k--;
        }
        
        long sum = 0;
        for(int i=0; i<gifts.length ;i++)
            sum+=gifts[i];

        return sum;
    }
}