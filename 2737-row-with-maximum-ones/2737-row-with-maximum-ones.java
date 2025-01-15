class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int maxCount = Integer.MIN_VALUE;
        int index=-1;

        int row  = mat.length;
        int col = mat[0].length;

        int count=0;
        for(int i=0; i<row; i++){
            
            count=0;
            for(int j=0; j<col; j++){

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