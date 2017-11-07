// 693. Binary Number with Alternating Bits
// Converting Integer to Binary String
class Solution {
    public boolean hasAlternatingBits(int n) {
        
        if (n < 0) {
            return false;
        }
        
        // Convert to Binary String
        String bStr = Integer.toBinaryString(n);
        
        // Set the Previous Bit to 0 because there won't be leading 0
        char prev = '0';
        
        for(int i = 0; i < bStr.length(); i++) {
            if (bStr.charAt(i) != prev) {
                prev = bStr.charAt(i);
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
