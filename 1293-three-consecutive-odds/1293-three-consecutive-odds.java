class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        int streak=0;

        for(int i=0; i<arr.length; i++){

            if(arr[i]%2!=0){
                streak++;
            }else{
                streak = 0;
            }

            if(streak==3)   return true;
        }
        return false;
        
    }
}