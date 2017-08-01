// 223. Rectangle Area

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int area1 = Math.abs(A - C) * Math.abs(B - D);
        int area2 = Math.abs(E - G) * Math.abs(F - H);
        
        // length of Duplicate Area (x axis)
        int l = 0;
        // width of Duplicate Area (y axis)
        int w = 0;
        
        // If duplicate area exists
        if ( Math.min(C, G) > Math.max(A, E) && Math.min(D, H) > Math.max(B, F) ) {
            l = Math.min(C, G) - Math.max(A, E);
            w = Math.min(D, H) - Math.max(B, F);
        }
        
        return area1 + area2 - l * w;
    }
}
