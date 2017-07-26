// 593. Valid Square

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        // Compute the distance's square between each pair of points
        double[] squares = new double [6];
        squares[0] = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);  // p1, p2
        squares[1] = Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2);  // p1, p3
        squares[2] = Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2);  // p1, p4
        squares[3] = Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2);  // p2, p3
        squares[4] = Math.pow(p2[0] - p4[0], 2) + Math.pow(p2[1] - p4[1], 2);  // p2, p4
        squares[5] = Math.pow(p3[0] - p4[0], 2) + Math.pow(p3[1] - p4[1], 2);  // p3, p4
        
        Arrays.sort(squares);  // Sort the squares
        // 0 is illegal
        if (squares[0] == 0.0) {
            return false;
        }
        
        /* If first 4 elements is equal, last 2 elements is equal, 
         * and the sum of first 4 elements is equal to the sum of last 2 elements,
         * then return true, else false 
        */
        // 2 Diagonals
        if (squares[4] != squares[5]) {
            return false;
        }
        // 4 Edges
        for(int i = 0; i < 3; i++) {
            if (squares[i] != squares[i + 1]) {
                return false;
            }
        }
        // edge^2 + edge^2 = diagonal^2
        if (squares[0] + squares[1] != squares[5]) {
            return false;
        }
        
        return true;
    }
