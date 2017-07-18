// 461. Hamming Distance

public class Solution {
    public int hammingDistance(int x, int y) {
        
        int distance = x ^ y;
        
        return Integer.bitCount(distance);
    }
}
