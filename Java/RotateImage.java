// 48. Rotate Image

/** Basic Idea
* Firstly swap upper rows and bottom rows, e.g.
* 1 2 3     7 8 9
* 4 5 6 --> 4 5 6
* 7 8 9     1 2 3
* Then swap symmetrically, e.g.
* 7 8 9     7 4 1
* 4 5 6 --> 8 5 2
* 1 2 3     9 6 3
**/

public class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int r, c;  // row and col number
        int temp;  // Used for swapping
        
        // Reverse Upper rows to Bottom
        for(r = 0; r < row / 2; r++) {
            for(c = 0; c < col; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[row-1-r][c];
                matrix[row-1-r][c] = temp;
            }
        }
        
        // Swap symmetrically
        for(r = 0; r < row; r++) {
            for(c = r + 1; c < col; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
}
