
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

class Solution {
    public void setZeroes(int[][] matrix) {
        int l = matrix.length;
        int b = matrix[0].length;

        // creating new array and coping all elements from orginal aray
        int[][] arr = new int[l][b];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 0) {
                    // if i found 0 in OG array then i will send thode index and make changes in
                    // copied array
                    makeZero(i, j, arr);
                }
            }
        }
        //copy the changes to the original array
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
    //make changes in copied array according to index 
    protected void makeZero(int row, int col, int[][] arr) {

        for (int i = 0; i < arr[0].length; i++) {
            arr[row][i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][col] = 0;
        }
    }

}



class Solution {
            public static int[][] check(int [][] matrix, int row, int col, int len1, int len2){
            for(int x=0; x<len1; x++){
                matrix[x][col]=0;
            }
            for(int y=0; y<len2; y++){
                matrix[row][y]=0;
            }

            return matrix;
        }

    public void setZeroes(int[][] matrix) {
        int len1= matrix.length;
        int len2= matrix[0].length;
        int row=0, col=0;
        int[][] dup= new int[len1][len2];
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){

               dup[i][j]=matrix[i][j];

            }
        }

        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){

                if(dup[i][j]==0){
                    row=i;
                    col=j;

                    check(matrix, row, col, len1, len2);
                }
            }
        }
    }
}
