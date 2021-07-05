import java.util.ArrayList;
import java.util.List;

/**
 * LC 54 - Spiral Matrix
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        /* Layer by layer traversal 
         * 1) traverse left - from columnLeftBound to columnRightBound, at rowLowerBound
         * 2) traverse downward - from rowLowerBound + 1 to rowUpperBound, at columnRightBound
         * 3) traverse right - from columnRightBound - 1 to columnLeftBound + 1, at rowUpperBound
         * 4) traverse upward - from rowUpperBound to rowLowerBound + 1, at columnLeftBound
         * after one layer, i.e. 1) - 4),
         * columnLeftBound += 1, columnRightBound -= 1
         * rowLowerBound += 1, rowUpperBound -= 1
         * with:
         * columnLeftBound initially being 0
         * columnRightBound initially being matrix[0].length - 1
         * rowLowerBound initially being 0
         * rowUpperBound initially being matrix.length - 1
         */
        int cLB = 0;
        int cRB = matrix[0].length - 1;
        int rLB = 0;
        int rUB = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while (rLB <= rUB && cLB <= cRB) {
            // left
            for (int c = cLB; c <= cRB; c++) {
                result.add(matrix[rLB][c]);
            }
            // down
            for (int r = rLB + 1; r <= rUB; r++) {
                result.add(matrix[r][cRB]);
            }
            
            // check if it is possible to go right & upward
            if (rLB < rUB && cLB < cRB) {
                // right
                for (int c = cRB - 1; c >= cLB + 1; c--) {
                    result.add(matrix[rUB][c]);
                }
                // up
                for (int r = rUB; r >= rLB + 1; r--) {
                    result.add(matrix[r][cLB]);
                }
            }
            
            cLB++;
            cRB--;
            rLB++;
            rUB--;
        }
        
        return result;
    }
}
