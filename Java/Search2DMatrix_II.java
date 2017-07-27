// 240. Search a 2D Matrix II

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0) {
            return false;
        }
        
        // Initial r and c, starting from the upper right element
        int r = 0;
        int c = matrix[0].length - 1;
        
        while (r < matrix.length && c >= 0) {
            // If current value < target, then row++
            if (matrix[r][c] < target) {
                r++;
            }
            // If current value > target, then col--
            else if (matrix[r][c] > target) {
                c--;
            }
            // If current value == target, then true
            else {
                return true;
            }
        }
        
        return false;
    }
}
