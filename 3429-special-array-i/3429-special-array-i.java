class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        int n = nums.length;
        if(n==1) return true;

        int flag=0;
        int Evencount=0;
        int Oddcount=0;

        for(int i=0; i<n; i++){

            if(nums[i]%2==0){
                Oddcount=0;
                 flag=0;
                 Evencount++;
            }
               
            else {
                Evencount=0;
                 flag=1;
                Oddcount++;
            }

            if(Oddcount==2 || Evencount==2)
                return false;
               
            
        }
        return true;



    }
}