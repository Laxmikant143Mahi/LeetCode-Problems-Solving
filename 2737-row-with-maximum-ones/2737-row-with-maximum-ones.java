class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int maxCount = Integer.MIN_VALUE;
        int index=-1;
        for(int i=0; i<mat.length; i++){
            
            int count=0;
            for(int j=0; j<mat[0].length; j++){

                if(mat[i][j] == 1)
                    count++;
            }

            if(count>maxCount){

                index = i;
                maxCount = count;
            }
        }

        return new int[]{index,maxCount};
    }
}