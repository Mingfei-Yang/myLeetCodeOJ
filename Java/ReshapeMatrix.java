// 566. Reshape the Matrix
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldR = nums.length; // row num of Old matrix
        int oldC = 0;
        int[][] reshapeM = new int[r][c];
        int curR = 0, curC = 0; // current row & col num tracking
        
        if (oldR > 0) {
            oldC = nums[0].length;
        }
        
        // If size does not match, return the old matrix
        if ( (oldR * oldC) != (r * c) ) {
            return nums;
        }
        
        // If the new row & col num are not changed, return the old matrix
        if (oldR == r && oldC == c) {
            return nums;
        }
        
        // Time Complexity - O(rowNum * colNum)
        for(int i = 0; i < oldR; i++) {
            for(int j = 0; j < oldC; j++) {
                reshapeM[curR][curC] = nums[i][j];  // Fill the new matrix slot
                curC++; // current col num++ after filling one slot
                
                // If current col num reaches the given c
                if (curC == c) {
                    //current row num++, current col num = 0
                    curR++;
                    curC = 0;
                    // If current row num reaches the given r, return
                    if (curR == r) {
                        return reshapeM;
                    }
                }
            }
        }
        
        return reshapeM;
    }
}
