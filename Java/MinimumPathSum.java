// 64. Minimum Path Sum
// Used a sum memorization matrix to store sums

public class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;        
        if (row == 0) {
            return 0;
        }
        
        int col = grid[0].length;      
        if (col == 0) {
            return 0;
        }
        // Memorization Matrix
        int[][] sumMemo = new int [row][col];
        int r, c;
        
        // compute each slot
        for(r = 0; r < row; r++) {
            for(c = 0; c < col; c++) {
                // First row
                if (r == 0 && c > 0) {
                    sumMemo[r][c] = grid[r][c] + sumMemo[r][c - 1];
                }
                // First column
                else if (c == 0 && r > 0) {
                    sumMemo[r][c] = grid[r][c] + sumMemo[r - 1][c];
                }
                // Other slots
                else if (r > 0 && c > 0) {
                    // Get the minimum sum so far
                    int minSum = Math.min(sumMemo[r][c - 1], sumMemo[r - 1][c]);
                    sumMemo[r][c] = minSum + grid[r][c];
                }
                // First slot
                else {
                    sumMemo[r][c] = grid[r][c];
                }
            }
        }
        
        return sumMemo[row - 1][col - 1];
    }
}
