class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> list = new ArrayList<>();

        int maxCandies = 0;

        for(int i=0; i<candies.length; i++)
            maxCandies = Math.max(maxCandies,candies[i]);
        
        for(int i=0; i<candies.length; i++){

            if(maxCandies<=candies[i]+extraCandies)
                list.add(true);
            else
                list.add(false);
                
        }
        return list;
    }
}