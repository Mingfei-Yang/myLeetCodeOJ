// 59. Spiral Matrix II
// Brute Force
public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int [n][n];
        
        int r = 0;  // current row
        int c = 0;  // current col
        
        int minR = 0;  // Upper edge
        int maxR = n - 1;  // Bottom edge
        int minC = 0;  // Left edge
        int maxC = n - 1;  // Right edge
        
        int num = 1;  // accumulator from 1 to n^2
        
        // R for right, D for down, L for left, U for up
        char d = 'R';
        
        // O(n^2)
        while (num <= n * n) {
            matrix[r][c] = num;  // fill the slot
            num++;  // num++
            
            // If direction is Right
            if (d == 'R') {
                c++;
                // If reaches right edge
                if (c > maxC) {
                    d = 'D';  // Change direction to Down
                    minR++;  // Upper edge++
                    c = maxC;  // col is at right edge
                    r++;  // move row
                }
            }
            // If direction is Down
            else if (d == 'D') {
                r++;
                // If reaches bottom edge
                if (r > maxR) {
                    d = 'L';  // Change direction to Left
                    maxC--;  // Right edge--
                    r = maxR;  // row is at bottom edge
                    c--;  // move col
                }
            }
            // If direction is Left
            else if (d == 'L') {
                c--;
                // If reaches left edge
                if (c < minC) {
                    d = 'U';  // Change direction to Up
                    maxR--;  // Bottom edge--
                    c = minC;  // col is at left edge
                    r--;  // move row
                }
            }
            // If direction is Up
            else {
                r--;
                // If reaches up edge
                if (r < minR) {
                    d = 'R';  // change direction to Right
                    minC++;  // Left edge++
                    r = minR;  // row is at upper edge
                    c++;  // move col
                }
            }
        }
        
        return matrix;
    }
}
