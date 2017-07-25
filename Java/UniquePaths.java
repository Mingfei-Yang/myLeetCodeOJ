// 62. Unique Paths

public class Solution {
    public int uniquePaths(int m, int n) {
        // Memorization Metrix
        int[][] pathMemo = new int [m + 1][n + 1];    // leave first row and column empty
        int r, c;
        
        // m = 1, O(m)
        for(r = 1; r < m + 1; r++) {
            pathMemo[r][1] = 1;
        }
            
        // n = 1, O(n)
        for(c = 1; c < n + 1; c++) {
            pathMemo[1][c] = 1;
        }
            
        // compute and memorize other slots, O(mn)
        for(r = 2; r < m + 1; r++) {
            for(c = 2; c < n + 1; c++) {
                pathMemo[r][c] = pathMemo[r-1][c] + pathMemo[r][c-1];
            }
        }
        
        return pathMemo[m][n];
    }
}
