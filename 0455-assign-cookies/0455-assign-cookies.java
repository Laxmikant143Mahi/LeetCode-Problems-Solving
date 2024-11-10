class Solution {
    public int findContentChildren(int[] greed, int[] cookies) {
        
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int j=0,count=0;
        for(int i=0; i<cookies.length && j<greed.length; i++){
            
            if(cookies[i]>=greed[j]){
                count++; 
                 j++;;
            }
           
            
        }
        return count;
    }
}