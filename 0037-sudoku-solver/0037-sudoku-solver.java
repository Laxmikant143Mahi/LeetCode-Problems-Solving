class Solution {

    public boolean canPlaceDigit(char[][] board, int row, int col, char digit){

        for(int i=0; i<9;i++ ){

            if(board[row][i] == digit){
                return false;
            }
        }

        for(int i=0; i<9; i++){

            if(board[i][col] == digit){
                return false;
            }
        }

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;


        for(int i=startRow; i<=startRow+2; i++){

            for(int j=startCol; j<=startCol+2; j++){

                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean sudokuHelper(char[][] board,  int row, int col){

        if(row==9)
            return true;
        
        int nextRow = row;
        int nextCol = col+1;

        if(nextCol == 9){
            nextRow = nextRow+1;
            nextCol = 0 ;
        }


        if(board[row][col] != '.'){
            
           return sudokuHelper(board,nextRow, nextCol);
        }

        for(char digit = '1'; digit<='9'; digit++){

            if(canPlaceDigit(board,row,col,digit)){
                board[row][col] = digit;

                if(sudokuHelper(board,nextRow, nextCol))
                    return true;
                
                board[row][col] = '.';
            }

        }
        return false;


    }
    public void solveSudoku(char[][] board) {
        
        sudokuHelper(board,0,0);
    }
}