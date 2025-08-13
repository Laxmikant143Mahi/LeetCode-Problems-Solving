class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int canEat = n/2;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){

            map.put(candyType[i], map.getOrDefault(candyType[i],0)+1);
        }

        return Math.min(canEat,map.size());
    }
}