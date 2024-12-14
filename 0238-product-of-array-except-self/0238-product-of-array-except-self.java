class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int pref[] = new int[n];
        int suff[] = new int[n];


        pref[0] = nums[0];

        for(int i=1; i<n; i++)
            pref[i] = pref[i-1] * nums[i];
        
        suff[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--)
            suff[i] = suff[i+1] * nums[i];
        
        int result[] = new int[n];

        result[0] = suff[1];
        for(int i=1; i<n-1; i++){

            result[i] = pref[i-1] * suff[i+1];
        }
        result[n-1] = pref[n-2];

        return result;
    }

}