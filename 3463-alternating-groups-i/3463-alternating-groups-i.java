class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        
        int start = 0 , end = 2;
        int count=0;

        while(end<colors.length){

            if(colors[start] == colors[end] && colors[start+1] != colors[end]){
                count++;
            }
            start++;
            end++;
        }

        if(colors[colors.length-2] == colors[0] && colors[colors.length-1] !=colors[0])
            count++;
        
        if(colors[colors.length-1] == colors[1] && colors[0]!=colors[1])
            count++;
            
        return count;
    }
}