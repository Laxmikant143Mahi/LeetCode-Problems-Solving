class Solution {
    public int diagonalSum(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;

        int sum = 0;
        
        for(int i=0; i<row; i++){

            
            sum+=mat[i][i];
        }

        
    
        
        int k = 0;
        for(int i=row-1; i>=0; i--){
            
            if(i-k!=0)
                 sum+=mat[k][i];
            k++;
        }

        return sum;


    }
}