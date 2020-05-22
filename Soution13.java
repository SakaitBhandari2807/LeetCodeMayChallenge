import java.math.*;
class Solution13 {
    public int countSquares(int[][] matrix) {
        int row = matrix.length,col= matrix[0].length;
        int cal[][] = new int[row][col];
        int count_squares = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0|| j==0 || matrix[i][j]==0){
                    cal[i][j] = matrix[i][j];
                }
                else{
                    cal[i][j] = 1+Math.min( Math.min(cal[i-1][j],cal[i-1][j-1]),cal[i][j-1]);
                }
                count_squares += cal[i][j];
            }
        }
        
        return count_squares;
    }
}
