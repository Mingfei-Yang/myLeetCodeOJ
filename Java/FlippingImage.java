// 832. Flipping an Image

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        // Boundary case
        if (A.length < 1 || A[0].length < 1) {
            return A;
        }
        
        /* Reverse each row and Invert */
        int r, c;  // row and column
        int swap;  // for swapping elements
        for (r = 0; r < A.length; r++) {
            /* Revert */
            for (c = 0; c < A[r].length / 2; c++) {
                // Swap the two elements at position c and (A[r].length - 1 - c)
                swap = A[r][c];  
                A[r][c] = A[r][A[r].length - 1 - c];
                A[r][A[r].length - 1 - c] = swap;
            }
            
            /* Invert */
            for (c = 0; c < A[r].length; c++) {
                A[r][c] = A[r][c] == 0 ? 1 : 0; 
            }
        }
        
        return A;
    }
}
