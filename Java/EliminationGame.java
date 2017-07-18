// 390. Elimination Game

public class Solution {
    public int lastRemaining(int n) {
        int head = 1;   // Current head of the list
        int len = n;    // Current len
        int round = 1;  // Elimination round, initially 1
        int step = 1;
        boolean direction = true;   // True - left to right, False - right to left
        
        while (len > 1) {
            // From left to right, or right to left while remaining list len is odd
            // Move the head because the old one would be eliminated
            if (direction || len % 2 == 1) {
                head += step;
            }
            
            len /= 2;   // Length is reduced by half every round
            step *= 2;  // Step = pow(2, round)
            direction = !direction;
        }
        
        return head;
    }
}
