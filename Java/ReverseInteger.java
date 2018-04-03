// 7. Reverse Integer

class Solution {
    public int reverse(int x) {
        
        int cur = 0;  // Current reverse number
        int prev = 0;  // Previous reverse number
        
        while (x != 0) {
            // Current reverse num = prev * 10 + tail digit of x
            cur = prev * 10 + x % 10;
            
            // Overflow check
            // prev could be calculated using cur, prev = (cur - tail digit of x) / 10
            // If (cur - x % 10) / 10 != prev, overflow detected
            if ((cur - x % 10) / 10 != prev) {
                return 0;
            }
            // Otherwise no overflow, continue to next iteration
            prev = cur;
            x /= 10;
        }
        
        return cur;
    }
}
