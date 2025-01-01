class Solution {
    public int maxScore(String s) {
        
        int n = s.length();

        int[] prefSum = new int[n];
        int[] suffSum = new int[n];

        if(s.charAt(0) == '0')
            prefSum[0] = 1;
        else 
            prefSum[0] = 0;
        
        if(s.charAt(n-1) == '1')
            suffSum[n-1] = 1;
        else 
            suffSum[n-1] = 0;

        for(int i=1; i<n; i++){

            if(s.charAt(i) == '0')
                prefSum[i] = prefSum[i-1] + 1;
            else 
                prefSum[i] = prefSum[i-1];
        }

        for(int i=n-2; i>=0; i--){

            if(s.charAt(i) == '1')
                suffSum[i] = suffSum[i+1] + 1;
            else 
                suffSum[i] = suffSum[i+1];
        }


        int maxScore = Integer.MIN_VALUE;

        for(int i=0; i<n-1; i++){

            maxScore = Math.max(prefSum[i]+suffSum[i+1], maxScore);
        }

        return maxScore;


    }
}